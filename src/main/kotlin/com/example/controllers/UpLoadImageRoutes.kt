package com.example.controllers

import io.ktor.http.*
import io.ktor.http.content.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.io.File

fun Route.addUploadImageRoutes(){

    post("api/v1/vehicles") {
        try {
            call.receiveMultipart().forEachPart { part ->
                when (part) {
                    is PartData.FileItem -> {
                        val fileName = part.originalFileName ?: "unknown"
                        val filePath = "./src/main/resources/static/vehicle/$fileName"
                        val file = File(filePath)

                        // An toàn với đường dẫn
                        if (file.parentFile.exists() || file.parentFile.mkdirs()) {
                            part.streamProvider().use { input ->
                                // Bảo mật: Giới hạn kích thước tệp tin, kiểm tra định dạng, ...

                                file.outputStream().buffered().use { output ->
                                    input.copyTo(output)
                                }
                            }
                            call.respondText("Upload successful: $filePath", status = HttpStatusCode.OK)
                        } else {
                            // Xử lý trường hợp không thể tạo đường dẫn
                            call.respondText("Cannot create directory", status = HttpStatusCode.InternalServerError)
                        }
                    }
                    is PartData.FormItem -> {
                        // Xử lý các loại FormItem nếu cần thiết
                        call.respondText("Form item received: ${part.value}", status = HttpStatusCode.OK)
                    }
                    else -> {
                        // Xử lý các loại khác nếu cần thiết
                        call.respondText("Unsupported part type", status = HttpStatusCode.BadRequest)
                    }
                }
            }
        } catch (e: Exception) {
            // Xử lý lỗi và phản hồi chi tiết
            call.respondText("Error uploading file: ${e.localizedMessage}", status = HttpStatusCode.InternalServerError)
        }
    }

}