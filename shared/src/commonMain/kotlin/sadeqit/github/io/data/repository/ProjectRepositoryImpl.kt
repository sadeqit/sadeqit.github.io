package sadeqit.github.io.data.repository

import sadeqit.github.io.data.content.projectData
import sadeqit.github.io.domain.model.Project
import sadeqit.github.io.domain.repository.ProjectRepository

class ProjectRepositoryImpl : ProjectRepository {

    override fun getProjects(): List<Project> {
        return projectData.sortedBy { it.order }
    }

    override fun getFeaturedProjects(): List<Project> {
        return projectData
            .filter { it.featured }
            .sortedBy { it.order }
    }
}