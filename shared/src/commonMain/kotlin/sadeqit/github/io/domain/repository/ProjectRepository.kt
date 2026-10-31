package sadeqit.github.io.domain.repository

import sadeqit.github.io.domain.model.Project

interface ProjectRepository {

    fun getProjects(): List<Project>

    fun getFeaturedProjects(): List<Project>
}