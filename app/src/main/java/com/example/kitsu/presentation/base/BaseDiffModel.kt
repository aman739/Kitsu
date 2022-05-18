package com.example.kitsu.presentation.base

interface BaseDiffModel {
    val id: Any
    override fun equals(other: Any?): Boolean
}