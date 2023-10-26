import {TYPE} from 'vue-toastification'

export default {
    // You can set default options here
    position: "top-center",
    pauseOnFocusLoss: true,
    pauseOnHover: true,
    draggable: true,
    draggablePercent: 0.6,
    showCloseButtonOnHover: false,
    hideProgressBar: true,
    closeButton: "button",
    icon: true,
    rtl: false,
    transition: "Vue-Toastification__bounce",
    maxToasts: 2,

    toastDefaults: {

      // ToastOptions object for each type of toast
      [TYPE.ERROR]: {
          timeout: 2500,
          closeButton: false,
        },
      [TYPE.SUCCESS]: {
          timeout: 3000,
          hideProgressBar: true,
      }    
    }
};