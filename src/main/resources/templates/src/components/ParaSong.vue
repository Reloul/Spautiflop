<template>
    <div id="para-song">
        <v-menu theme="dark" id="menu-add-song">
            <template v-slot:activator="{ props }">
                <v-icon icon="mdi-dots-vertical" v-bind="props" id="para-add-song"></v-icon>
            </template>

            <v-list id="add-song">
                <v-list-item id="item-list-add">
                    <v-list-item-title>Ajouter à la Playlist :
                        <v-list id="add-song">
                            <v-list-item v-for="(item, i) in items" :key="i" value="i" id="item-list-add">
                                <v-list-item-title>{{ item.title }}</v-list-item-title>
                            </v-list-item>
                        </v-list>
                    </v-list-item-title>
                    <v-list-item-title>Supprimer de la Playlist:
                        <v-list id="add-song">
                            <v-list-item v-for="(item, i) in suppr" :key="i" value="i" id="item-list-add">
                                <v-list-item-title>{{ item.title }}</v-list-item-title>
                            </v-list-item>
                        </v-list>  
                    </v-list-item-title>                            
                </v-list-item>
            </v-list>
        </v-menu>
    </div>
</template>

<script>
export default {
    name: "ParaSong",
    props: {
        items: Array,
        suppr: Array,
    }
}
</script>

<style scoped>
    #add-song{
        background-color: #273043;
    }
    #item-list-add{
        color: #b9d1db;
    }
</style>