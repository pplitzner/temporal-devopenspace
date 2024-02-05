package devopenspace.temporal.carleasing.carleasing00.starter

import devopenspace.temporal.carleasing.carleasing00.CustomerJourneyWorkflow
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
    val workflow = client.newWorkflowStub<CustomerJourneyWorkflow>(workflowOptions)
    WorkflowClient.start(workflow::customerJourney,"Renault ZOE", "patrick.plitzner@aldautomotive.com")

//    val result = workflow.customerJourney("Renault ZOE", "patrick.plitzner@aldautomotive.com")
//    println(result)
}
