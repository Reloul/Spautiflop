"use strict";(self["webpackChunktest"]=self["webpackChunktest"]||[]).push([[289],{5715:function(e,l,a){a.r(l),a.d(l,{default:function(){return _}});var t=a(6252),n=a(9963),i=a(9079),o=a(8677);const s=e=>((0,t.dD)("data-v-6f6bef4c"),e=e(),(0,t.Cn)(),e),r={id:"inscription"},d=s((()=>(0,t._)("h1",null,"Inscription",-1))),u={id:"input-group"},p=s((()=>(0,t._)("div",{id:"Erreur"},[(0,t._)("span",{id:"pseudoError"},"Erreur, pseudo déjà pris !")],-1))),c={id:"Erreur"},v={id:"mdpIError"},m={id:"Erreur"},f={id:"confirmError"},h=s((()=>(0,t._)("div",{id:"basForm"},[(0,t._)("div",{id:"input-temp"},[(0,t._)("div",{id:"input"},[(0,t._)("input",{type:"submit",id:"submit",value:"S'inscrire"})])])],-1))),y={id:"sign-up"};function g(e,l,a,s,g,b){const k=(0,t.up)("router-link");return(0,t.wg)(),(0,t.iD)("div",r,[d,(0,t._)("div",u,[(0,t._)("form",{onSubmit:l[4]||(l[4]=(0,n.iM)(((...e)=>b.handleSubmit&&b.handleSubmit(...e)),["prevent"]))},[(0,t.Wm)(o.h,{label:"Rentrez votre Pseudonyme",required:"",id:"pseudo",modelValue:g.pseudonyme,"onUpdate:modelValue":l[0]||(l[0]=e=>g.pseudonyme=e)},null,8,["modelValue"]),p,(0,t.Wm)(o.h,{label:"Entrez votre Mot de Passe",required:"",id:"password",type:"password",modelValue:g.password,"onUpdate:modelValue":l[1]||(l[1]=e=>g.password=e)},null,8,["modelValue"]),(0,t._)("div",c,[(0,t.wy)((0,t._)("span",v,"Erreur, mot de passe non valide !",512),[[n.F8,!g.passwordValid]])]),(0,t.Wm)(o.h,{label:"Confirmez votre Mot de Passe",required:"",id:"confirmPassword",type:"password",modelValue:g.confirmPassword,"onUpdate:modelValue":l[2]||(l[2]=e=>g.confirmPassword=e)},null,8,["modelValue"]),(0,t._)("div",m,[(0,t.wy)((0,t._)("span",f,"Erreur, pas le même mot de passe !",512),[[n.F8,g.passwordMismatch]])]),(0,t.Wm)(i.Z,{ref:"image",label:"Photo de Profil",variant:"filled",accept:"image/*","prepend-icon":"mdi-camera",id:"profil-picture",required:"",modelValue:g.profilPicture,"onUpdate:modelValue":l[3]||(l[3]=e=>g.profilPicture=e)},null,8,["modelValue"]),h,(0,t._)("div",y,[(0,t.Wm)(k,{to:"/connexion"},{default:(0,t.w5)((()=>[(0,t.Uk)("Connexion")])),_:1})])],32)])])}var b=a(1089),k=a(3002),V=a(2201),w=a(6472),C=a(2262),S={name:"PageInscription",setup(){const e=(0,V.tv)(),l=(0,b.l)(),a=(0,k.pm)(),t=(0,C.iH)(null);return{toast:a,queryStore:l,image:t,router:e}},data(){return{pseudonyme:"",password:"",confirmPassword:"",profilPicture:[],passwordMismatch:!1,passwordValid:!0}},methods:{async handleSubmit(){if(""===this.pseudonyme||""===this.password)return void toast.error("Veuillez remplir tous les champs !");if(this.password!==this.confirmPassword)return this.passwordMismatch=!0,void this.toast.warning("Les mots de passe ne correspondent pas !");this.passwordMismatch=!1;const e=/^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\S+$).{8,}$/,l=e.test(this.password);if(!l)return this.toast.warning("Mot de passe non valide ! (8 caractères minimum, 1 majuscule, 1 minuscule, 1 chiffre)"),void(this.passwordValid=!1);this.passwordValid=!0;const a=new FormData;a.append("pseudo",this.pseudonyme),a.append("password",this.password),this.image.files[0]&&a.append("photo",this.image.files[0]);await this.queryStore.registerUser(a);this.queryStore.HttpCode===w.OK?(this.toast.success("Inscription réussie !"),setTimeout((()=>{this.router.push("/connexion")}),1e3)):this.queryStore.HttpCode===w.vS?this.toast.error("Nom d'utilisateur déjà utilisé !"):this.toast.error("Erreur dans l'inscription !")}}},I=a(3744);const W=(0,I.Z)(S,[["render",g],["__scopeId","data-v-6f6bef4c"]]);var _=W},9079:function(e,l,a){a.d(l,{Z:function(){return M}});var t=a(6252),n=a(9963),i=a(8975),o=a(2139),s=a(9e3),r=a(4405),d=a(6560),u=a(2716),p=a(584),c=a(9748),v=a(2262),m=a(6533),f=a(8676),h=a(6719),y=a(3099);const g=Symbol.for("vuetify:v-chip-group"),b=(0,m.U)({column:Boolean,filter:Boolean,valueComparator:{type:Function,default:f.vZ},...(0,s.l)(),...(0,d.k4)({selectedClass:"v-chip--selected"}),...(0,u.Q)(),...(0,p.x$)(),...(0,c.bk)({variant:"tonal"})},"VChipGroup");(0,h.ev)()({name:"VChipGroup",props:b(),emits:{"update:modelValue":e=>!0},setup(e,l){let{slots:a}=l;const{themeClasses:n}=(0,p.ER)(e),{isSelected:i,select:o,next:s,prev:u,selected:c}=(0,d._v)(e,g);return(0,r.AF)({VChip:{color:(0,v.Vh)(e,"color"),disabled:(0,v.Vh)(e,"disabled"),filter:(0,v.Vh)(e,"filter"),variant:(0,v.Vh)(e,"variant")}}),(0,y.L)((()=>(0,t.Wm)(e.tag,{class:["v-chip-group",{"v-chip-group--column":e.column},n.value,e.class],style:e.style},{default:()=>[a.default?.({isSelected:i,select:o,next:s,prev:u,selected:c.value})]}))),{}}});var k=a(875),V=a(7737),w=a(6454),C=a(8942),S=a(6947),I=a(6596),W=a(8475),_=a(1316),z=a(8247),F=a(3664),A=a(2283),E=a(7284);const P=(0,m.U)({activeClass:String,appendAvatar:String,appendIcon:I.lE,closable:Boolean,closeIcon:{type:I.lE,default:"$delete"},closeLabel:{type:String,default:"$vuetify.close"},draggable:Boolean,filter:Boolean,filterIcon:{type:String,default:"$complete"},label:Boolean,link:{type:Boolean,default:void 0},pill:Boolean,prependAvatar:String,prependIcon:I.lE,ripple:{type:[Boolean,Object],default:!0},text:String,modelValue:{type:Boolean,default:!0},onClick:(0,f.as)(),onClickOnce:(0,f.as)(),...(0,w.m)(),...(0,s.l)(),...(0,C.f)(),...(0,S.c)(),...(0,d.YQ)(),...(0,z.I)(),...(0,F.GN)(),...(0,A.Z)(),...(0,u.Q)({tag:"span"}),...(0,p.x$)(),...(0,c.bk)({variant:"tonal"})},"VChip"),B=(0,h.ev)()({name:"VChip",directives:{Ripple:E.H},props:P(),emits:{"click:close":e=>!0,"update:modelValue":e=>!0,"group:selected":e=>!0,click:e=>!0},setup(e,l){let{attrs:a,emit:s,slots:r}=l;const{t:u}=(0,W.bU)(),{borderClasses:v}=(0,w.P)(e),{colorClasses:m,colorStyles:f,variantClasses:h}=(0,c.c1)(e),{densityClasses:y}=(0,C.t)(e),{elevationClasses:b}=(0,S.Y)(e),{roundedClasses:I}=(0,z.b)(e),{sizeClasses:E}=(0,A.t)(e),{themeClasses:P}=(0,p.ER)(e),B=(0,_.z)(e,"modelValue"),x=(0,d.Yt)(e,g,!1),U=(0,F.nB)(e,a),H=(0,t.Fl)((()=>!1!==e.link&&U.isLink.value)),$=(0,t.Fl)((()=>!e.disabled&&!1!==e.link&&(!!x||e.link||U.isClickable.value))),q=(0,t.Fl)((()=>({"aria-label":u(e.closeLabel),onClick(e){e.stopPropagation(),B.value=!1,s("click:close",e)}})));function Y(e){s("click",e),$.value&&(U.navigate?.(e),x?.toggle())}function M(e){"Enter"!==e.key&&" "!==e.key||(e.preventDefault(),Y(e))}return()=>{const l=U.isLink.value?"a":e.tag,a=!(!e.appendIcon&&!e.appendAvatar),s=!(!a&&!r.append),d=!(!r.close&&!e.closable),u=!(!r.filter&&!e.filter)&&x,p=!(!e.prependIcon&&!e.prependAvatar),g=!(!p&&!r.prepend),w=!x||x.isSelected.value;return B.value&&(0,t.wy)((0,t.Wm)(l,{class:["v-chip",{"v-chip--disabled":e.disabled,"v-chip--label":e.label,"v-chip--link":$.value,"v-chip--filter":u,"v-chip--pill":e.pill},P.value,v.value,w?m.value:void 0,y.value,b.value,I.value,E.value,h.value,x?.selectedClass.value,e.class],style:[w?f.value:void 0,e.style],disabled:e.disabled||void 0,draggable:e.draggable,href:U.href.value,tabindex:$.value?0:void 0,onClick:Y,onKeydown:$.value&&!H.value&&M},{default:()=>[(0,c.Ux)($.value,"v-chip"),u&&(0,t.Wm)(i.Zq,{key:"filter"},{default:()=>[(0,t.wy)((0,t.Wm)("div",{class:"v-chip__filter"},[r.filter?(0,t.Wm)(k.z,{key:"filter-defaults",disabled:!e.filterIcon,defaults:{VIcon:{icon:e.filterIcon}}},r.filter):(0,t.Wm)(V.t,{key:"filter-icon",icon:e.filterIcon},null)]),[[n.F8,x.isSelected.value]])]}),g&&(0,t.Wm)("div",{key:"prepend",class:"v-chip__prepend"},[r.prepend?(0,t.Wm)(k.z,{key:"prepend-defaults",disabled:!p,defaults:{VAvatar:{image:e.prependAvatar,start:!0},VIcon:{icon:e.prependIcon,start:!0}}},r.prepend):(0,t.Wm)(t.HY,null,[e.prependIcon&&(0,t.Wm)(V.t,{key:"prepend-icon",icon:e.prependIcon,start:!0},null),e.prependAvatar&&(0,t.Wm)(o.V,{key:"prepend-avatar",image:e.prependAvatar,start:!0},null)])]),(0,t.Wm)("div",{class:"v-chip__content"},[r.default?.({isSelected:x?.isSelected.value,selectedClass:x?.selectedClass.value,select:x?.select,toggle:x?.toggle,value:x?.value.value,disabled:e.disabled})??e.text]),s&&(0,t.Wm)("div",{key:"append",class:"v-chip__append"},[r.append?(0,t.Wm)(k.z,{key:"append-defaults",disabled:!a,defaults:{VAvatar:{end:!0,image:e.appendAvatar},VIcon:{end:!0,icon:e.appendIcon}}},r.append):(0,t.Wm)(t.HY,null,[e.appendIcon&&(0,t.Wm)(V.t,{key:"append-icon",end:!0,icon:e.appendIcon},null),e.appendAvatar&&(0,t.Wm)(o.V,{key:"append-avatar",end:!0,image:e.appendAvatar},null)])]),d&&(0,t.Wm)("div",(0,t.dG)({key:"close",class:"v-chip__close"},q.value),[r.close?(0,t.Wm)(k.z,{key:"close-defaults",defaults:{VIcon:{icon:e.closeIcon,size:"x-small"}}},r.close):(0,t.Wm)(V.t,{key:"close-icon",icon:e.closeIcon,size:"x-small"},null)])]}),[[(0,t.Q2)("ripple"),$.value&&e.ripple,null]])}}});var x=a(7467),U=a(4014),H=a(4417),$=a(2246),q=a(9483);const Y=(0,m.U)({chips:Boolean,counter:Boolean,counterSizeString:{type:String,default:"$vuetify.fileInput.counterSize"},counterString:{type:String,default:"$vuetify.fileInput.counter"},multiple:Boolean,showSize:{type:[Boolean,Number],default:!1,validator:e=>"boolean"===typeof e||[1e3,1024].includes(e)},...(0,H.c)({prependIcon:"$file"}),modelValue:{type:Array,default:()=>[],validator:e=>(0,f.FT)(e).every((e=>null!=e&&"object"===typeof e))},...(0,U.hy)({clearable:!0})},"VFileInput"),M=(0,h.ev)()({name:"VFileInput",inheritAttrs:!1,props:Y(),emits:{"click:control":e=>!0,"mousedown:control":e=>!0,"update:focused":e=>!0,"update:modelValue":e=>!0},setup(e,l){let{attrs:a,emit:n,slots:i}=l;const{t:o}=(0,W.bU)(),s=(0,_.z)(e,"modelValue"),{isFocused:r,focus:d,blur:u}=(0,$.K)(e),p=(0,t.Fl)((()=>"boolean"!==typeof e.showSize?e.showSize:void 0)),c=(0,t.Fl)((()=>(s.value??[]).reduce(((e,l)=>{let{size:a=0}=l;return e+a}),0))),m=(0,t.Fl)((()=>(0,f.XE)(c.value,p.value))),h=(0,t.Fl)((()=>(s.value??[]).map((l=>{const{name:a="",size:t=0}=l;return e.showSize?`${a} (${(0,f.XE)(t,p.value)})`:a})))),g=(0,t.Fl)((()=>{const l=s.value?.length??0;return e.showSize?o(e.counterSizeString,l,m.value):o(e.counterString,l)})),b=(0,v.iH)(),k=(0,v.iH)(),V=(0,v.iH)(),w=(0,t.Fl)((()=>r.value||e.active)),C=(0,t.Fl)((()=>["plain","underlined"].includes(e.variant)));function S(){V.value!==document.activeElement&&V.value?.focus(),r.value||d()}function I(e){F(e)}function z(e){n("mousedown:control",e)}function F(e){V.value?.click(),n("click:control",e)}function A(l){l.stopPropagation(),S(),(0,t.Y3)((()=>{s.value=[],(0,f.dr)(e["onClick:clear"],l)}))}return(0,t.YP)(s,(e=>{const l=!Array.isArray(e)||!e.length;l&&V.value&&(V.value.value="")})),(0,y.L)((()=>{const l=!(!i.counter&&!e.counter),n=!(!l&&!i.details),[o,d]=(0,f.An)(a),[{modelValue:p,...v}]=H.q.filterProps(e),[y]=(0,U.g8)(e);return(0,t.Wm)(H.q,(0,t.dG)({ref:b,modelValue:s.value,"onUpdate:modelValue":e=>s.value=e,class:["v-file-input",{"v-text-field--plain-underlined":C.value},e.class],style:e.style,"onClick:prepend":I},o,v,{centerAffix:!C.value,focused:r.value}),{...i,default:l=>{let{id:a,isDisabled:n,isDirty:o,isReadonly:p,isValid:v}=l;return(0,t.Wm)(U.hF,(0,t.dG)({ref:k,"prepend-icon":e.prependIcon,onMousedown:z,onClick:F,"onClick:clear":A,"onClick:prependInner":e["onClick:prependInner"],"onClick:appendInner":e["onClick:appendInner"]},y,{id:a.value,active:w.value||o.value,dirty:o.value,disabled:n.value,focused:r.value,error:!1===v.value}),{...i,default:l=>{let{props:{class:a,...o}}=l;return(0,t.Wm)(t.HY,null,[(0,t.Wm)("input",(0,t.dG)({ref:V,type:"file",readonly:p.value,disabled:n.value,multiple:e.multiple,name:e.name,onClick:e=>{e.stopPropagation(),p.value&&e.preventDefault(),S()},onChange:e=>{if(!e.target)return;const l=e.target;s.value=[...l.files??[]]},onFocus:S,onBlur:u},o,d),null),(0,t.Wm)("div",{class:a},[!!s.value?.length&&(i.selection?i.selection({fileNames:h.value,totalBytes:c.value,totalBytesReadable:m.value}):e.chips?h.value.map((l=>(0,t.Wm)(B,{key:l,size:"small",color:e.color},{default:()=>[l]}))):h.value.join(", "))])])}})},details:n?e=>(0,t.Wm)(t.HY,null,[i.details?.(e),l&&(0,t.Wm)(t.HY,null,[(0,t.Wm)("span",null,null),(0,t.Wm)(x._,{active:!!s.value?.length,value:g.value},i.counter)])]):void 0})})),(0,q.F)({},b,k,V)}})}}]);
//# sourceMappingURL=inscription.a723581c.js.map