package devopenspace.temporal.carleasing.carleasing00

import io.temporal.activity.ActivityOptions
import io.temporal.workflow.Workflow
import io.temporal.workflow.WorkflowInterface
import io.temporal.workflow.WorkflowMethod
import java.time.Duration

@WorkflowInterface
interface CustomerJourneyWorkflow {
    @WorkflowMethod
    fun customerJourney(car: String, email: String): Boolean

}

class CustomerJourneyWorkflowImpl: CustomerJourneyWorkflow {
    // init activities
    private val activityOptions: ActivityOptions = ActivityOptions.newBuilder()
        .setStartToCloseTimeout(Duration.ofSeconds(5))
        .build()
    private val customerActivity = Workflow.newActivityStub(CustomerJourneyActivity::class.java, activityOptions)

    override fun customerJourney(car: String, email: String): Boolean {

        customerActivity.sendWelcomeMail(email)

        val success = customerActivity.creditCheck(email)

        if(success) {
            customerActivity.leaseCar(car, email)

            val waitTime = Duration.ofSeconds(14)
            println("Waiting ${waitTime.toSeconds()} seconds")
            Workflow.sleep(waitTime)

            customerActivity.sendCheckupMail(email)
        }
        return success
    }
}
