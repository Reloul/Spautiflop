import { createApp} from "vue";
import { createPinia } from "pinia";
import App from "./App.vue";
import vuetify from "./plugins/vuetify";
import pinia from "./plugins/pinia";
import router from "./router";
import Toast from "vue-toastification";
import options from "./plugins/toastification";
import "vue-toastification/dist/index.css";


createApp(App).use(vuetify).use(pinia).use(router).use(Toast, options).mount("#app");
