package com.olabode.wilson.pytutor.utils

import com.olabode.wilson.pytutor.models.tutorial.TopicResponse

/**
 * Created by Ogheneruona Onobrakpeya on 9/10/20.
 */

fun genTopicResponse(): List<TopicResponse> {
    return listOf(
        TopicResponse(orderKey = 1, Title = "Introduction", description = "Get an overview of Python and what it entails.", noOfPages = 3, topicId = "introduction", isLocked = true, isCompleted = true),
        TopicResponse(orderKey = 2, Title = "Variables", description = "Learn how to store assign data to variables.", noOfPages = 3, topicId = "variables", isLocked = true, isCompleted = true),
        TopicResponse(orderKey = 3, Title = "Data Types", description = "See the different data types Python has to offer.", noOfPages = 3, topicId = "data_types", isLocked = true, isCompleted = true),
        TopicResponse(orderKey = 4, Title = "Operators", description = "Learn about Python operators, their order and associated types.", noOfPages = 3, topicId = "operators", isLocked = true, isCompleted = true),
        TopicResponse(orderKey = 5, Title = "Input/Output", description = "Handle user input and perform output operations.", noOfPages = 3, topicId = "input_output", isLocked = true, isCompleted = true),
        TopicResponse(orderKey = 6, Title = "Data Structures", description = "Learn about data structures.", noOfPages = 3, topicId = "data_structures", isLocked = true, isCompleted = true),
        TopicResponse(orderKey = 7, Title = "Lists", description = "Learn about Python lists.", noOfPages = 3, topicId = "lists", isLocked = true, isCompleted = true),
        TopicResponse(orderKey = 8, Title = "Tuples", description = "Learn about Python tuples.", noOfPages = 3, topicId = "tuples", isLocked = true, isCompleted = true),
        TopicResponse(orderKey = 9, Title = "Dictionaries", description = "Learn about Python dictionaries.", noOfPages = 3, topicId = "dictionaries", isLocked = true, isCompleted = true),
        TopicResponse(orderKey = 10, Title = "Sets", description = "Learn about Python sets.", noOfPages = 3, topicId = "sets", isLocked = true, isCompleted = true),
        TopicResponse(orderKey = 11, Title = "Flow Control", description = "Learn how to control the flow of your programs.", noOfPages = 3, topicId = "flow_control", isLocked = true, isCompleted = true),
        TopicResponse(orderKey = 12, Title = "If...Else Statements", description = "Learn flow control with if...else statements.", noOfPages = 3, topicId = "if_else_statements", isLocked = true, isCompleted = true),
        TopicResponse(orderKey = 13, Title = "For Loops", description = "Learn flow control with for loops.", noOfPages = 3, topicId = "for_loops", isLocked = true, isCompleted = true),
        TopicResponse(orderKey = 14, Title = "While Loops", description = "Learn flow control with while loops.", noOfPages = 3, topicId = "while_loops", isLocked = true, isCompleted = true),
        TopicResponse(orderKey = 15, Title = "Break & Continue", description = "Use break and continue statements for further flow control.", noOfPages = 3, topicId = "break_continue", isLocked = true, isCompleted = true),
        TopicResponse(orderKey = 16, Title = "Functions", description = "Learn how to group procedures in functions.", noOfPages = 3, topicId = "functions", isLocked = true, isCompleted = true),
        TopicResponse(orderKey = 17, Title = "Modules & Importing", description = "Learn about Python modules and importing.", noOfPages = 3, topicId = "modules_importing", isLocked = true, isCompleted = true),
        TopicResponse(orderKey = 18, Title = "Classes", description = "Learn about Python classes.", noOfPages = 3, topicId = "classes", isLocked = true, isCompleted = true),
        TopicResponse(orderKey = 19, Title = "File Handling", description = "Learn how to read and manage files.", noOfPages = 3, topicId = "file_handling", isLocked = true, isCompleted = true),
        TopicResponse(orderKey = 20, Title = "Exception Handling", description = "Learn how to deal with exceptions.", noOfPages = 3, topicId = "exception_handling", isLocked = true, isCompleted = true)
    )
}