<template>
    <v-row justify="center">
        <v-dialog v-model="dialog" persistent width="700" theme="dark" >
            <template v-slot:activator="{ props }">
                <div id="add-playlist">
                    <v-icon v-bind="props" icon="mdi-plus" color="#b9d1db" size="small"></v-icon>
                </div>
            </template>
            <v-card id="#dialog-card">
                <v-card-title id="card-title">
                    <span class="text-h5">Nouvelle Playlist</span>
                </v-card-title>
                <v-card-text id="card-text">
                    <v-container>
                        <v-row id="row">
                            <v-col cols="12" sm="12" md="12">
                                <v-text-field label="Nom de la Playlist" required id="playlist-name"></v-text-field>
                            </v-col>
                            <v-col cols="12">
                                <v-file-input label="Image pour la Playlist" variant="filled" prepend-icon="mdi-camera" id="playlist-picture"></v-file-input>                                            
                            </v-col>
                        </v-row>
                    </v-container>
                </v-card-text>
                <v-card-actions id="card-action">
                    <v-spacer></v-spacer>
                    <v-btn color="#b9d1db" variant="text" @click="dialog = false">
                        Fermer
                    </v-btn>
                    <v-btn color="#b9d1db" variant="text" @click="dialog = false">
                        Sauvegarder
                    </v-btn>
                </v-card-actions>
            </v-card>
        </v-dialog>
    </v-row>
</template>

<script>
export default {
    name: 'AddPlaylist',
    data(){
        return{
            dialog: false,
        }
    }
}
</script>

<style scoped>
    
    #input-photo{
        margin-top: 20px;
    }
    #card-title{
        padding-top: 20px;
        background-color: #273043;
        color: #b9d1db;
    }
    #card-text{
         background-color: #273043;       
    }
    #card-action{
         background-color: #273043;       
    }

    #row{
        color: #b9d1db;
    }
</style>