package devopenspace.temporal.carleasing

import devopenspace.temporal.carleasing.carleasing01.CarLeasingWorkflow
import io.temporal.client.WorkflowClient
import io.temporal.client.WorkflowOptions
import io.temporal.client.newWorkflowStub
import io.temporal.serviceclient.WorkflowServiceStubs

fun main(){
    val service = WorkflowServiceStubs.newLocalServiceStubs()
    val client = WorkflowClient.newInstance(service)
    val workflowOptions = WorkflowOptions.newBuilder()
        .setTaskQueue(QUEUE_NAME)
        .build()
    val workflow = client.newWorkflowStub<CarLeasingWorkflow>(workflowOptions)
    val result = workflow.leaseACar("Renault ZOE", "patrick.plitzner@aldautomotive.com")
    println(result)
}
