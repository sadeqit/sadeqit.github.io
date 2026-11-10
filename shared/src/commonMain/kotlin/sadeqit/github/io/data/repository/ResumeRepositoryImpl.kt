
package sadeqit.github.io.data.repository

import sadeqit.github.io.data.content.resumeContent
import sadeqit.github.io.domain.model.ResumeContent
import sadeqit.github.io.domain.repository.ResumeRepository

class ResumeRepositoryImpl : ResumeRepository {

    override fun getResume(): ResumeContent = resumeContent
}
