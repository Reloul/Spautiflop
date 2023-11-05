"use strict";(self["webpackChunktest"]=self["webpackChunktest"]||[]).push([[495],{5768:function(e,l,a){a.r(l),a.d(l,{default:function(){return S}});var t=a(6252),n=a(9963),i=a(9079),u=a(7737),o=a(8677);const s=e=>((0,t.dD)("data-v-3f23286e"),e=e(),(0,t.Cn)(),e),d={id:"main-add-music"},r={id:"accueil"},c=s((()=>(0,t._)("div",{id:"span-principal"},[(0,t._)("span",null,"Page Principale")],-1))),p={id:"ajout"},v=s((()=>(0,t._)("u",null,"ici",-1))),m={id:"add-music"},f=s((()=>(0,t._)("h2",null,"Ajouter votre Musique",-1))),h=s((()=>(0,t._)("div",{id:"submit"},[(0,t._)("input",{type:"submit",value:"Ajouter Musique"})],-1)));function b(e,l,a,s,b,g){const y=(0,t.up)("router-link");return(0,t.wg)(),(0,t.iD)("div",d,[(0,t.Wm)(y,{to:"/pagePrincipale",style:{"text-decoration":"none",color:"inherit"}},{default:(0,t.w5)((()=>[(0,t._)("div",r,[(0,t.Wm)(u.t,{icon:"mdi-home",color:"#b9d1db",size:"40"}),c])])),_:1}),(0,t._)("div",p,[(0,t._)("span",null,[(0,t.Uk)(" Vous ne trouvez pas votre artiste ou l'album de la musique? Rajoutez les "),(0,t.Wm)(y,{to:"/ajoutAll",style:{"text-decoration":"none",color:"inherit"}},{default:(0,t.w5)((()=>[v])),_:1}),(0,t.Uk)(" ! ")])]),(0,t._)("div",m,[f,(0,t._)("form",{onSubmit:l[6]||(l[6]=(0,n.iM)(((...e)=>g.handleSubmit&&g.handleSubmit(...e)),["prevent"]))},[(0,t.Wm)(o.h,{label:"Nom de la Musique",required:"",id:"music",modelValue:b.inputMusicName,"onUpdate:modelValue":l[0]||(l[0]=e=>b.inputMusicName=e)},null,8,["modelValue"]),(0,t.Wm)(o.h,{label:"Nom de l'Artiste",required:"",id:"artist-song",modelValue:b.inputMusicArtist,"onUpdate:modelValue":l[1]||(l[1]=e=>b.inputMusicArtist=e)},null,8,["modelValue"]),(0,t.Wm)(o.h,{label:"Nom de l'Album/Single",required:"",id:"album-song",modelValue:b.inputMusicAlbum,"onUpdate:modelValue":l[2]||(l[2]=e=>b.inputMusicAlbum=e)},null,8,["modelValue"]),(0,t.Wm)(o.h,{label:"Genre de la musique",required:"",id:"genre-song",modelValue:b.inputMusicGenre,"onUpdate:modelValue":l[3]||(l[3]=e=>b.inputMusicGenre=e)},null,8,["modelValue"]),(0,t.Wm)(i.Z,{ref:"cover",label:"Image de la Musique",variant:"filled",accept:"image/*","prepend-icon":"mdi-camera",id:"song-picture",required:"",modelValue:b.inputMusicPicture,"onUpdate:modelValue":l[4]||(l[4]=e=>b.inputMusicPicture=e)},null,8,["modelValue"]),(0,t.Wm)(i.Z,{ref:"music",label:"Fichier de la Musique",variant:"filled",accept:"audio/*","prepend-icon":"mdi-camera",id:"song-file",required:"",onChange:g.handleFileChange,modelValue:b.inputMusicLink,"onUpdate:modelValue":l[5]||(l[5]=e=>b.inputMusicLink=e)},null,8,["onChange","modelValue"]),h],32)])])}var g=a(1089),y=a(2262),k=a(3002),V={setup(){const e=(0,y.iH)(null),l=(0,y.iH)(null),a=(0,g.l)(),t=(0,k.pm)();return{queryStore:a,cover:e,music:l,toast:t}},name:"AddMusic",data(){return{inputMusicName:"",inputMusicArtist:"",inputMusicAlbum:"",inputMusicGenre:"",inputMusicPicture:[],inputMusicLink:[],audioDuration:null}},methods:{handleSubmit(){let e=new FormData;e.append("name",this.inputMusicName),e.append("artist",this.inputMusicArtist),e.append("album",this.inputMusicAlbum),e.append("genre",this.inputMusicGenre),e.append("cover",this.cover.files[0]),e.append("music",this.music.files[0]),this.queryStore.fetchJwt("/api/song/add",e,"POST")?this.toast.success("Musique ajoutée avec succès"):this.toast.error("Erreur lors de l'ajout de la musique")},handleFileChange(e){const l=e.target.files[0],a=new FileReader;a.onload=e=>{const l=new Audio(e.target.result);l.onloadedmetadata=()=>{this.audioDuration=l.duration}},a.readAsDataURL(l)}}},C=a(3744);const W=(0,C.Z)(V,[["render",b],["__scopeId","data-v-3f23286e"]]);var S=W},9079:function(e,l,a){a.d(l,{Z:function(){return D}});var t=a(6252),n=a(9963),i=a(8975),u=a(2139),o=a(9e3),s=a(4405),d=a(6560),r=a(2716),c=a(584),p=a(9748),v=a(2262),m=a(6533),f=a(8676),h=a(6719),b=a(3099);const g=Symbol.for("vuetify:v-chip-group"),y=(0,m.U)({column:Boolean,filter:Boolean,valueComparator:{type:Function,default:f.vZ},...(0,o.l)(),...(0,d.k4)({selectedClass:"v-chip--selected"}),...(0,r.Q)(),...(0,c.x$)(),...(0,p.bk)({variant:"tonal"})},"VChipGroup");(0,h.ev)()({name:"VChipGroup",props:y(),emits:{"update:modelValue":e=>!0},setup(e,l){let{slots:a}=l;const{themeClasses:n}=(0,c.ER)(e),{isSelected:i,select:u,next:o,prev:r,selected:p}=(0,d._v)(e,g);return(0,s.AF)({VChip:{color:(0,v.Vh)(e,"color"),disabled:(0,v.Vh)(e,"disabled"),filter:(0,v.Vh)(e,"filter"),variant:(0,v.Vh)(e,"variant")}}),(0,b.L)((()=>(0,t.Wm)(e.tag,{class:["v-chip-group",{"v-chip-group--column":e.column},n.value,e.class],style:e.style},{default:()=>[a.default?.({isSelected:i,select:u,next:o,prev:r,selected:p.value})]}))),{}}});var k=a(875),V=a(7737),C=a(6454),W=a(8942),S=a(6947),A=a(6596),I=a(8475),M=a(1316),_=a(8247),F=a(3664),z=a(2283),q=a(7284);const w=(0,m.U)({activeClass:String,appendAvatar:String,appendIcon:A.lE,closable:Boolean,closeIcon:{type:A.lE,default:"$delete"},closeLabel:{type:String,default:"$vuetify.close"},draggable:Boolean,filter:Boolean,filterIcon:{type:String,default:"$complete"},label:Boolean,link:{type:Boolean,default:void 0},pill:Boolean,prependAvatar:String,prependIcon:A.lE,ripple:{type:[Boolean,Object],default:!0},text:String,modelValue:{type:Boolean,default:!0},onClick:(0,f.as)(),onClickOnce:(0,f.as)(),...(0,C.m)(),...(0,o.l)(),...(0,W.f)(),...(0,S.c)(),...(0,d.YQ)(),...(0,_.I)(),...(0,F.GN)(),...(0,z.Z)(),...(0,r.Q)({tag:"span"}),...(0,c.x$)(),...(0,p.bk)({variant:"tonal"})},"VChip"),B=(0,h.ev)()({name:"VChip",directives:{Ripple:q.H},props:w(),emits:{"click:close":e=>!0,"update:modelValue":e=>!0,"group:selected":e=>!0,click:e=>!0},setup(e,l){let{attrs:a,emit:o,slots:s}=l;const{t:r}=(0,I.bU)(),{borderClasses:v}=(0,C.P)(e),{colorClasses:m,colorStyles:f,variantClasses:h}=(0,p.c1)(e),{densityClasses:b}=(0,W.t)(e),{elevationClasses:y}=(0,S.Y)(e),{roundedClasses:A}=(0,_.b)(e),{sizeClasses:q}=(0,z.t)(e),{themeClasses:w}=(0,c.ER)(e),B=(0,M.z)(e,"modelValue"),U=(0,d.Yt)(e,g,!1),x=(0,F.nB)(e,a),P=(0,t.Fl)((()=>!1!==e.link&&x.isLink.value)),G=(0,t.Fl)((()=>!e.disabled&&!1!==e.link&&(!!U||e.link||x.isClickable.value))),H=(0,t.Fl)((()=>({"aria-label":r(e.closeLabel),onClick(e){e.stopPropagation(),B.value=!1,o("click:close",e)}})));function j(e){o("click",e),G.value&&(x.navigate?.(e),U?.toggle())}function D(e){"Enter"!==e.key&&" "!==e.key||(e.preventDefault(),j(e))}return()=>{const l=x.isLink.value?"a":e.tag,a=!(!e.appendIcon&&!e.appendAvatar),o=!(!a&&!s.append),d=!(!s.close&&!e.closable),r=!(!s.filter&&!e.filter)&&U,c=!(!e.prependIcon&&!e.prependAvatar),g=!(!c&&!s.prepend),C=!U||U.isSelected.value;return B.value&&(0,t.wy)((0,t.Wm)(l,{class:["v-chip",{"v-chip--disabled":e.disabled,"v-chip--label":e.label,"v-chip--link":G.value,"v-chip--filter":r,"v-chip--pill":e.pill},w.value,v.value,C?m.value:void 0,b.value,y.value,A.value,q.value,h.value,U?.selectedClass.value,e.class],style:[C?f.value:void 0,e.style],disabled:e.disabled||void 0,draggable:e.draggable,href:x.href.value,tabindex:G.value?0:void 0,onClick:j,onKeydown:G.value&&!P.value&&D},{default:()=>[(0,p.Ux)(G.value,"v-chip"),r&&(0,t.Wm)(i.Zq,{key:"filter"},{default:()=>[(0,t.wy)((0,t.Wm)("div",{class:"v-chip__filter"},[s.filter?(0,t.Wm)(k.z,{key:"filter-defaults",disabled:!e.filterIcon,defaults:{VIcon:{icon:e.filterIcon}}},s.filter):(0,t.Wm)(V.t,{key:"filter-icon",icon:e.filterIcon},null)]),[[n.F8,U.isSelected.value]])]}),g&&(0,t.Wm)("div",{key:"prepend",class:"v-chip__prepend"},[s.prepend?(0,t.Wm)(k.z,{key:"prepend-defaults",disabled:!c,defaults:{VAvatar:{image:e.prependAvatar,start:!0},VIcon:{icon:e.prependIcon,start:!0}}},s.prepend):(0,t.Wm)(t.HY,null,[e.prependIcon&&(0,t.Wm)(V.t,{key:"prepend-icon",icon:e.prependIcon,start:!0},null),e.prependAvatar&&(0,t.Wm)(u.V,{key:"prepend-avatar",image:e.prependAvatar,start:!0},null)])]),(0,t.Wm)("div",{class:"v-chip__content"},[s.default?.({isSelected:U?.isSelected.value,selectedClass:U?.selectedClass.value,select:U?.select,toggle:U?.toggle,value:U?.value.value,disabled:e.disabled})??e.text]),o&&(0,t.Wm)("div",{key:"append",class:"v-chip__append"},[s.append?(0,t.Wm)(k.z,{key:"append-defaults",disabled:!a,defaults:{VAvatar:{end:!0,image:e.appendAvatar},VIcon:{end:!0,icon:e.appendIcon}}},s.append):(0,t.Wm)(t.HY,null,[e.appendIcon&&(0,t.Wm)(V.t,{key:"append-icon",end:!0,icon:e.appendIcon},null),e.appendAvatar&&(0,t.Wm)(u.V,{key:"append-avatar",end:!0,image:e.appendAvatar},null)])]),d&&(0,t.Wm)("div",(0,t.dG)({key:"close",class:"v-chip__close"},H.value),[s.close?(0,t.Wm)(k.z,{key:"close-defaults",defaults:{VIcon:{icon:e.closeIcon,size:"x-small"}}},s.close):(0,t.Wm)(V.t,{key:"close-icon",icon:e.closeIcon,size:"x-small"},null)])]}),[[(0,t.Q2)("ripple"),G.value&&e.ripple,null]])}}});var U=a(7467),x=a(4014),P=a(4417),G=a(2246),H=a(9483);const j=(0,m.U)({chips:Boolean,counter:Boolean,counterSizeString:{type:String,default:"$vuetify.fileInput.counterSize"},counterString:{type:String,default:"$vuetify.fileInput.counter"},multiple:Boolean,showSize:{type:[Boolean,Number],default:!1,validator:e=>"boolean"===typeof e||[1e3,1024].includes(e)},...(0,P.c)({prependIcon:"$file"}),modelValue:{type:Array,default:()=>[],validator:e=>(0,f.FT)(e).every((e=>null!=e&&"object"===typeof e))},...(0,x.hy)({clearable:!0})},"VFileInput"),D=(0,h.ev)()({name:"VFileInput",inheritAttrs:!1,props:j(),emits:{"click:control":e=>!0,"mousedown:control":e=>!0,"update:focused":e=>!0,"update:modelValue":e=>!0},setup(e,l){let{attrs:a,emit:n,slots:i}=l;const{t:u}=(0,I.bU)(),o=(0,M.z)(e,"modelValue"),{isFocused:s,focus:d,blur:r}=(0,G.K)(e),c=(0,t.Fl)((()=>"boolean"!==typeof e.showSize?e.showSize:void 0)),p=(0,t.Fl)((()=>(o.value??[]).reduce(((e,l)=>{let{size:a=0}=l;return e+a}),0))),m=(0,t.Fl)((()=>(0,f.XE)(p.value,c.value))),h=(0,t.Fl)((()=>(o.value??[]).map((l=>{const{name:a="",size:t=0}=l;return e.showSize?`${a} (${(0,f.XE)(t,c.value)})`:a})))),g=(0,t.Fl)((()=>{const l=o.value?.length??0;return e.showSize?u(e.counterSizeString,l,m.value):u(e.counterString,l)})),y=(0,v.iH)(),k=(0,v.iH)(),V=(0,v.iH)(),C=(0,t.Fl)((()=>s.value||e.active)),W=(0,t.Fl)((()=>["plain","underlined"].includes(e.variant)));function S(){V.value!==document.activeElement&&V.value?.focus(),s.value||d()}function A(e){F(e)}function _(e){n("mousedown:control",e)}function F(e){V.value?.click(),n("click:control",e)}function z(l){l.stopPropagation(),S(),(0,t.Y3)((()=>{o.value=[],(0,f.dr)(e["onClick:clear"],l)}))}return(0,t.YP)(o,(e=>{const l=!Array.isArray(e)||!e.length;l&&V.value&&(V.value.value="")})),(0,b.L)((()=>{const l=!(!i.counter&&!e.counter),n=!(!l&&!i.details),[u,d]=(0,f.An)(a),[{modelValue:c,...v}]=P.q.filterProps(e),[b]=(0,x.g8)(e);return(0,t.Wm)(P.q,(0,t.dG)({ref:y,modelValue:o.value,"onUpdate:modelValue":e=>o.value=e,class:["v-file-input",{"v-text-field--plain-underlined":W.value},e.class],style:e.style,"onClick:prepend":A},u,v,{centerAffix:!W.value,focused:s.value}),{...i,default:l=>{let{id:a,isDisabled:n,isDirty:u,isReadonly:c,isValid:v}=l;return(0,t.Wm)(x.hF,(0,t.dG)({ref:k,"prepend-icon":e.prependIcon,onMousedown:_,onClick:F,"onClick:clear":z,"onClick:prependInner":e["onClick:prependInner"],"onClick:appendInner":e["onClick:appendInner"]},b,{id:a.value,active:C.value||u.value,dirty:u.value,disabled:n.value,focused:s.value,error:!1===v.value}),{...i,default:l=>{let{props:{class:a,...u}}=l;return(0,t.Wm)(t.HY,null,[(0,t.Wm)("input",(0,t.dG)({ref:V,type:"file",readonly:c.value,disabled:n.value,multiple:e.multiple,name:e.name,onClick:e=>{e.stopPropagation(),c.value&&e.preventDefault(),S()},onChange:e=>{if(!e.target)return;const l=e.target;o.value=[...l.files??[]]},onFocus:S,onBlur:r},u,d),null),(0,t.Wm)("div",{class:a},[!!o.value?.length&&(i.selection?i.selection({fileNames:h.value,totalBytes:p.value,totalBytesReadable:m.value}):e.chips?h.value.map((l=>(0,t.Wm)(B,{key:l,size:"small",color:e.color},{default:()=>[l]}))):h.value.join(", "))])])}})},details:n?e=>(0,t.Wm)(t.HY,null,[i.details?.(e),l&&(0,t.Wm)(t.HY,null,[(0,t.Wm)("span",null,null),(0,t.Wm)(U._,{active:!!o.value?.length,value:g.value},i.counter)])]):void 0})})),(0,H.F)({},y,k,V)}})}}]);
//# sourceMappingURL=ajoutMusique.f61bf060.js.map