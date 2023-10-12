package devopenspace.temporal.carleasing

import devopenspace.temporal.carleasing.carleasing01.CarLeasingWorkflowImpl
import devopenspace.temporal.carleasing.carleasing01.CustomerActivityImpl
import io.temporal.client.WorkflowClient
import io.temporal.serviceclient.WorkflowServiceStubs
import io.temporal.worker.WorkerFactory
import io.temporal.worker.registerWorkflowImplementationType

const val QUEUE_NAME = "car-leasing-queue"
fun main(){
    val service = WorkflowServiceStubs.newLocalServiceStubs()
    val client = WorkflowClient.newInstance(service)
    val factory = WorkerFactory.newInstance(client)
    val worker = factory.newWorker(QUEUE_NAME)
    worker.registerWorkflowImplementationType<CarLeasingWorkflowImpl>()
    worker.registerActivitiesImplementations(CustomerActivityImpl())
    factory.start()
}
