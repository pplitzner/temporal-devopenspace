package devopenspace.temporal.carleasing.carleasing00.starter

import devopenspace.temporal.carleasing.carleasing00.CustomerJourneyActivityImpl
import devopenspace.temporal.carleasing.carleasing00.CustomerJourneyWorkflowImpl
import io.temporal.client.WorkflowClient
import io.temporal.serviceclient.WorkflowServiceStubs
import io.temporal.worker.WorkerFactory
import io.temporal.worker.registerWorkflowImplementationType

const val QUEUE_NAME = "customer-journey-queue"
fun main(){
    val service = WorkflowServiceStubs.newLocalServiceStubs()
    val client = WorkflowClient.newInstance(service)
    val factory = WorkerFactory.newInstance(client)
    val worker = factory.newWorker(QUEUE_NAME)
    worker.registerWorkflowImplementationType<CustomerJourneyWorkflowImpl>()
    worker.registerActivitiesImplementations(CustomerJourneyActivityImpl())
    factory.start()
}
