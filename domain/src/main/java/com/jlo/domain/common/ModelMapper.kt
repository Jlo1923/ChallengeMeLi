package com.jlo.domain.common

abstract class ModelMapper<Model, Data> {

    abstract fun toModel(data: Data): Model

    open fun fromModel(model: Model): Data? {
        return null
    }

    fun toListModel(dataList: List<Data>): List<Model> {
        return dataList.map(this::toModel)
    }

    fun fromListModel(modelList: List<Model>): List<Data> {
        return modelList.map { fromModel(it)!! }
    }
}
