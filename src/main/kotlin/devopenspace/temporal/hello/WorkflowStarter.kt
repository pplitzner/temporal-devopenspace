package devopenspace.temporal.hello

import io.temporal.client.WorkflowClient
import io.temporal.client.WorkflowOptions
import io.temporal.client.newWorkflowStub
import io.temporal.serviceclient.WorkflowServiceStubs

fun main(){
    val service = WorkflowServiceStubs.newLocalServiceStubs()
    val client = WorkflowClient.newInstance(service)
    val workflowOptions = WorkflowOptions.newBuilder()
        .setTaskQueue("hello-queue")
        .build()
    val workflow = client.newWorkflowStub<HelloWorkflow>(workflowOptions)
    val result = workflow.sayHello("Patrick")
    println(result)
}
