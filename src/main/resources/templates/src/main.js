import { createApp} from "vue";
import App from "./App.vue";
import vuetify from "./plugins/vuetify";
import router from "./router";
import pinia from "./plugins/pinia";
import Toast from "vue-toastification";
import options from "./plugins/toastification";
import "vue-toastification/dist/index.css";


createApp(App).use(vuetify).use(router).use(pinia).use(Toast, options).mount("#app");
