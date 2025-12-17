# Project description
This project is a scheduling engine that takes a list of staff and roles, and generates a schedule
# Programming language and justification
We chose Java because it is a general purpose object oriented language and is commonly used in the industry
# System design overview
The project uses 3 model classes (Schedule, Shift, Staff). The main program logic is in ScheduleManager and ScheduleValidation. 
# Exception handling strategy 
Exceptions are handled through try-catch blocks but errors are often thrown if certain data is null (ie shifts)
# Description of parallel component
The parallel component in this project is in ScheduleValidation using the Java function parallelStream() for iterating through the list of staff
