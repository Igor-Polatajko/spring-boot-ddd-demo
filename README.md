## Modules description:

- **common** - _module, that contains shared classes for all contexts (e.g. exceptions)_
- **feedback** - _module, that represents feedback context_
- **main** - _module, that contains main() method, configs and db migrations_
- **rest** - _module, that exposes some API methods from another modules as REST API_
- **user** - _module, that represents user context_
- **web** - _module, that responsible from web application, in case of server side rending_

## Key architecture points:

- only API interfaces from `api` package and dto from `api.dto` package can be used on the application level, outside of the module, that represents the context
- no shared domain models are allowed
- one context should have one primary domain object - "aggregate root"
- only aggregate root can be referenced from another context on domain level
- use `id` on domain object level to reference aggregate root from another context
- one context should access only it's own tables
- no shared tables between modules are allowed
- no cross-module joins are allowed