# transaction-service

### Service manages customer's transactions

-------------------------------------------

**Architecture:** **Onion** architecture in combination with **Domain-Driven Design** patterns

Implemented ideas:
  - onion architecture + ddd;
  - basic centralized exceptions handling aproach;
  - basic unit tests;
  - retry mechanics + partial response returning.

To Do:
  - increase tests coverage (e.i. integration, project structure);
  - add Docker support;
  - use GitHub Actions;
  - add tiny UI;
  - CI/CD (code analyzers, test coverage, vulnerability check, deployment scripts and tools etc.).

End Points:
  - GET: [http://localhost:8092/v1/transactions?account_id={id}](http://localhost:8092/v1/transactions?account_id={id}) - return all transactions for 'account_id', multiple request parameter.
  - POST: [http://localhost:8092/v1/transactions](http://localhost:8092/v1/transactions) - create new transaction linked to customer account - 'account_id'.  
    Body:  
    `{"accountId":"9ff67ec7-8e46-42c5-b1f0-4d86484d466b","txType":"INITIAL","amount":100,"details":"Initial transaction request"}`. 
      
H2 DB:   
  - There is script which preconfigure customers, there are ids:  
  `9ff67ec7-8e46-42c5-b1f0-4d86484d466b, 771493f4-cf89-4acf-b131-5c527c495f1d, 8258a5f3-b6fa-4785-ad81-0b12bdfc6b05`.  
  
Run Application (from service root):
  - ./mvnw clean install
  - ./mvnw spring-boot:run -rf :app
