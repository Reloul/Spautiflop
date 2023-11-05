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
                            <v-list-item v-for="(item, i) in itemsR" :key="i" value="i" id="item-list-add" @click="addSong(item, id)">
                                <v-list-item-title>{{ item.name }}</v-list-item-title>
                            </v-list-item>
                        </v-list>
                    </v-list-item-title>
                    <v-list-item-title>Supprimer de la Playlist:
                        <v-list id="add-song">
                            <v-list-item v-for="(item, i) in supprR" :key="i" value="i" id="item-list-add" @click="deleteFromPlaylist(item, id)">
                                <v-list-item-title >{{ item.name }}</v-list-item-title>
                            </v-list-item>
                        </v-list>  
                    </v-list-item-title>                            
                </v-list-item>
            </v-list>
        </v-menu>
    </div>
</template>

<script>
import {useUserStore} from "../store/userStore";
import {ref} from "vue";


export default {
    setup(props) {
        const userStore = useUserStore();

        const itemsR = ref(props.items);
        const supprR = ref(props.suppr);

        const addSong = (item, id) => {
            supprR.value.push(item);
            itemsR.value.splice(itemsR.value.indexOf(item), 1);

            if(item.name == "Favoris")
                userStore.like(props.id);
            
            else
                userStore.addSongToPlaylist(item.id, id);
        }

        const deleteFromPlaylist = (item, id) => {
            itemsR.value.push(item);
            supprR.value.splice(supprR.value.indexOf(item), 1);

            if(item.name == "Favoris")
                userStore.dislike(props.id);
            
            else
                userStore.removeSongFromPlaylist(item.id, id);
        }

        return {
            itemsR,
            supprR,
            deleteFromPlaylist,
            addSong
        }
    },
    name: "ParaSong",
    props: {
        items: Array,
        suppr: Array,
        id: {
            type: Number,
            required: true,
        },
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