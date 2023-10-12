package devopenspace.temporal.carleasing.carleasing01

import io.temporal.activity.ActivityOptions
import io.temporal.workflow.Workflow
import io.temporal.workflow.WorkflowInterface
import io.temporal.workflow.WorkflowMethod
import java.time.Duration

@WorkflowInterface
interface CarLeasingWorkflow {
    @WorkflowMethod
    fun leaseACar(carName: String, email: String)
}
class CarLeasingWorkflowImpl: CarLeasingWorkflow {
    // init activities
    val activityOptions = ActivityOptions.newBuilder()
        .setStartToCloseTimeout(Duration.ofSeconds(5))
        .build()
    val customerActivity = Workflow.newActivityStub(CustomerActivity::class.java, activityOptions)

    override fun leaseACar(carName: String, email: String) {

        val isKnowCustomer = customerActivity.isKnownCustomer(email)

        if(!isKnowCustomer) {
            customerActivity.sendWelcomeMail(email)
        }
        customerActivity.sendCarInfoMail(email, carName)
    }
}
