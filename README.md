# temporal-devopenspace
Temporal 101 with Kotlin
# Initial setup
* Download and install [Temporal CLI](https://github.com/temporalio/cli)
* Start temporal server via `temporal server start-dev --db-filename your_temporal.db`
* Start WorkerStarter `main()`
* Start Workflow via CLI with `temporal workflow start --type HelloWorkflow --task-queue hello-queue`

