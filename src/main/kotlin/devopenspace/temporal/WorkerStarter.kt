package devopenspace.temporal

import io.temporal.client.WorkflowClient
import io.temporal.serviceclient.WorkflowServiceStubs
import io.temporal.worker.WorkerFactory
import io.temporal.worker.registerWorkflowImplementationType

fun main(){
    val client = WorkflowClient.newInstance(WorkflowServiceStubs.newLocalServiceStubs())
    val factory = WorkerFactory.newInstance(client)
    val worker = factory.newWorker("hello-queue")
    worker.registerWorkflowImplementationType<HelloWorkflowImpl>()
    factory.start()
}