package com.lambda.prototype.basic

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler

class HelloWorld : RequestHandler<Any, String> {

    override fun handleRequest(input : Any, context : Context) : String {
        context.logger.log("Input: $input")
        return "Hello, $input!"
    }

}
