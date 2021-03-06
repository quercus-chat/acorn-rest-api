package dev.murad.acorn

import auth.Acorn
import entity.enrol.EnrolledCourse
import entity.plan.PlannedCourse
import org.springframework.web.bind.annotation.*
import java.lang.RuntimeException

@RestController
@RequestMapping("/courses")
class CourseController {

    @PostMapping("/enrolled")
    fun enrolled(account: Account): MutableList<EnrolledCourse>? {
        val acorn = Acorn(account.utorid, account.password)

        try {
            acorn.doLogin()
        } catch (e: RuntimeException) {
            throw AuthException("Authentication Error")
        }

        return (acorn.courseManager.appliedCourses)
    }

    @PostMapping("/planned")
    fun planned(account: Account): MutableList<PlannedCourse>? {
        val acorn = Acorn(account.utorid, account.password)

        try {
            acorn.doLogin()
        } catch (e: RuntimeException) {
            throw AuthException("Authentication Error")
        }

        return (acorn.courseManager.plannedCourses)
    }




}