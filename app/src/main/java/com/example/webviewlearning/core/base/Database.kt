package com.example.webviewlearning.core.base

import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import io.realm.kotlin.ext.query
import io.realm.kotlin.query.RealmResults

class Database {
    private val config = RealmConfiguration.Builder(
        schema = setOf(LinkModel::class)
    ).schemaVersion(3).build()
    private val realm: Realm = Realm.open(config)

    fun addLink(model: LinkModel){
        realm.writeBlocking {
            copyToRealm(
                model
            )
        }
    }

    fun getAll(): MutableList<LinkItem> {
        return realm.query<LinkModel>().find().map { it.convertToLocalItem() }.toMutableList().asReversed()
    }

}