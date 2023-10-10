package devopenspace.temporal

import io.temporal.workflow.WorkflowInterface
import io.temporal.workflow.WorkflowMethod

@WorkflowInterface
interface HelloWorkflow {

    @WorkflowMethod
    fun sayHello()

}

class HelloWorkflowImpl: HelloWorkflow {

    override fun sayHello() {
        println("Hello Devopenspace")
    }

}
