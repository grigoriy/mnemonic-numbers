# Problem

# Assumptions

# Input

# Output

# Acceptance Criteria
## Example Input

## Expected Output

# Design
## Model
### TemplateModel (does smth useful)
* CAN
    * do smth useful
* IS
    * a BaseModel
    * one of { A, B }
* HAS:
    * property X
* MUST
    * have 0 < X < 11
    * satisfy constraints
 
## Edge cases

## Questions
- How to deal with TemplateModel's failures?
    - How failures affect other entities, models, modules, etc?
    - Who handles failures?
- Does TemplateModel need an identity?
    - Is it a value object?
    - Does it have state?
    - How the identity is determined (generated/provided, globally unique or not, additional semantics (order, type), public/private)?
- Is TemplateModel's mutable state well encapsulated?
- Is TemplateModel's implementation well encapsulated?
- Is TemplateModel easily testable?
- Is the solution easily testable?
- Is the solution's models, components loosely bound?
- How well does the solution scale?
    - Batch vs stream
    - Eager vs lazy
    - Can it be parallelized?
        - What processes can be parallelized?
            - What mutable state is shared?
    - Can it be distributed?
        - What data can be distributed?
            - What consistency tolerance is expected?
            - What availability is expected?
            - What partition tolerance is expected?
            - What consistency, availability & partition tolerance is expected?
            - What mutable state is shared?
            - What needs to be synchronized?
                - Provide examples of possible race conditions.
                - Can it be solved with optimistic concurrency control (OCC)?
                - Can it be solved with locking?
                - What are the alternatives?
- How data should be normalised?
- What modules should the application be divided in?
    * Appointments
    * Patients' health records
- What layers should the Appointments module consist of?
    * view (browser)
    * transport (HTTP)
    * presentation (JSON)
    * core (REST server)
- Does TemplateModel adhere to SOLID principles?
    - Does TemplateModel have single responsibility?
    - Does TemplateModel
    - Can TemplateModel substitute parent models?
    - Can TemplateModel be substituted by children models?
    - Do interfaces provide no more than required by clients?
    - Are all the dependencies of TemplateModel injected?
- Does the solution adhere to the Reactive standards?
    - Is it message-driven?
    - Is it resilient?
        - Is it well-tested?
        - What is the failure-handling strategy?
    - Is it elastic?
        - How does it scale up?
        - How does it scale down?
    - Is it responsive?
- What data structures come to mind when trying to raise the level of abstraction?
    - map
    - set
    - list
    - array
    - queue
    - stack
    - circular buffer
    - tree
    - trie
- What algorithms come to mind when trying to raise the level of abstraction?
    - divide & conquer
    - dynamic programming
    - greedy
    - memoization
- What software development patterns come to mind when trying to raise the level of abstraction?
    - publisher/subscriber
    - singleton
    - factory
    - proxy
    - cache
    - immutable
    - value object
    - builder
    - case class
    - case object
    - type class
    - decorator
    - implicit
    - adapter
    - strategy
    - chain of responsibility
    - template method
    - algebraic data type
    - stream
- What architectural styles and technologies come to mind when trying to raise the level of abstraction?
    - MVC
    - streaming
    - async
    - microservices
    - reactive
    - REST
    - actors
    - event sourcing
    - message queues
    - RDBMS
    - NoSQL
    - transactions
    - optimistic/pessimistic transactions
    - distributed

## Example flow
