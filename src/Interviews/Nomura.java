package Interviews;

public class Nomura {
    public static void main(String[] args) {

    }
}



//Require -
//Employye 1 - Employee 2

//File System
// File -> Huge Data
//Get Data -> Process Data -> Employee-> Fetch the remaining from DATA  -> Enrich -> Condition's on Data [ Role based condition ]

//Status - EmplID , Status


//Cache -> Filter by Groups. ( Indexing Role -  Ids from the fetch )


//Consumer -> Role -> Retrive Data -> Validation -> NACK Employee -> Persist.


//Before sending the client ->
//After client fetches it ->



//Employee
// id PK
// Role role
// etc
//DOJ
//DOL
//Mamger id


//Status
//id FK
//Status status



//Role
//FTE
//Contingent
//

//Status
//VALID
//INVALID
//



//Controller
//Scheduled
//RestAPI
//-> TRigger FILE SYTEM


///getEmp/(Roles)
//List<Employee>


//Service
//File System
//Location -> Read File -> parallel (Employee) -> Database -> ConcurrentList<EmpId> -> perist -> Status -> NACK / ACK

//group -> Status - Employee
//
//
// Listerner (topic) ->Employee ->  (ACK/NACK -> persist) :DALWRITE


//DALReadService
//Fetch from Database ( Employee details )
//Read


//DALWriteService
//insertin/ persisting
//Write

//Utils method
//reuse any func.