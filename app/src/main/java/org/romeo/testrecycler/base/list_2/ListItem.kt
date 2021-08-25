package org.romeo.testrecycler.base.list_2

interface ListItem {
    fun areContentsTheSame(other: ListItem) =
        equals(other)

    fun areItemsTheSame(other: ListItem) =
        equals(other)
}