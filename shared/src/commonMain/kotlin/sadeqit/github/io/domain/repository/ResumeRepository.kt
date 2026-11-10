package sadeqit.github.io.domain.repository

import sadeqit.github.io.domain.model.ResumeContent

interface ResumeRepository {
    fun getResume(): ResumeContent
}
