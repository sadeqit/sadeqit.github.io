
package sadeqit.github.io.domain.model

data class ResumeContent(
    val fullName: String,
    val summary: String,
    val skills: List<ResumeSkillCategory>,
    val experiences: List<ResumeExperience>,
    val projects: List<ResumeProject>,
    val socialLinks: List<ResumeSocialLink>,
)

data class ResumeSkillCategory(
    val title: String,
    val skills: List<String>,
)

data class ResumeExperience(
    val title: String,
    val description: String,
)

data class ResumeProject(
    val name: String,
    val description: String,
    val technologies: List<String>,
    val githubUrl: String? = null,
    val appUrl: String? = null,
    val projectId: String? = null,
)

data class ResumeSocialLink(
    val title: String,
    val url: String,
)