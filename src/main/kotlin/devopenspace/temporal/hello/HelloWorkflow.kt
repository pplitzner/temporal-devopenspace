package devopenspace.temporal.hello

import io.temporal.workflow.WorkflowInterface
import io.temporal.workflow.WorkflowMethod

@WorkflowInterface
interface HelloWorkflow {

    @WorkflowMethod
    fun sayHello(name: String): String

}

class HelloWorkflowImpl: HelloWorkflow {

    override fun sayHello(name: String): String {
        return "Hello $name"
    }

}
