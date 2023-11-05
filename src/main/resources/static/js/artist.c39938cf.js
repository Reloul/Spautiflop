"use strict";(self["webpackChunktest"]=self["webpackChunktest"]||[]).push([[708],{2882:function(t,e,i){i.d(e,{Z:function(){return x}});var a=i(6252);const s=t=>((0,a.dD)("data-v-b74e26a0"),t=t(),(0,a.Cn)(),t),l={id:"album"},n=s((()=>(0,a._)("div",{id:"title"},[(0,a._)("div",{id:"span-title"},[(0,a._)("span",null,"Albums")]),(0,a._)("div",{id:"hr-title"},[(0,a._)("hr")])],-1))),r={id:"resume-album"};function d(t,e,i,s,d,u){const o=(0,a.up)("AlbumCard"),m=(0,a.up)("routerLink");return(0,a.wg)(),(0,a.iD)("div",l,[n,(0,a._)("div",r,[((0,a.wg)(!0),(0,a.iD)(a.HY,null,(0,a.Ko)(i.albums,(t=>((0,a.wg)(),(0,a.iD)("div",{id:"album",key:t},[(0,a.Wm)(m,{to:"/album/"+t.id,style:{"text-decoration":"none",color:"inherit"}},{default:(0,a.w5)((()=>[(0,a.Wm)(o,{image:t.image,name:t.name,date:t.date,artist:t.artist,id:t.id},null,8,["image","name","date","artist","id"])])),_:2},1032,["to"])])))),128))])])}var u=i(3577);const o={id:"album-card"},m={id:"album-photo"},c=["src"],p={id:"text-album"},b={id:"name"},v={id:"type-album"};function _(t,e,i,s,l,n){const r=(0,a.up)("router-link");return(0,a.wg)(),(0,a.iD)("div",null,[(0,a.Wm)(r,{to:"/album/"+i.id,id:"routerLink",style:{"text-decoration":"none",color:"inherit"}},{default:(0,a.w5)((()=>[(0,a._)("div",o,[(0,a._)("div",m,[(0,a._)("img",{src:i.image},null,8,c)]),(0,a._)("div",p,[(0,a._)("div",b,[(0,a._)("span",null,(0,u.zw)(i.name),1)]),(0,a._)("div",v,[(0,a._)("span",null,[(0,a.Uk)((0,u.zw)(i.date)+" - ",1),(0,a.Wm)(r,{to:"/artist/"+i.artist.id,id:"routerLink",style:{"text-decoration":"none",color:"inherit"}},{default:(0,a.w5)((()=>[(0,a.Uk)((0,u.zw)(i.artist.name),1)])),_:1},8,["to"])])])])])])),_:1},8,["to"])])}var h={name:"AlbumCard",props:{image:String,name:String,date:String,artist:String,id:Number}},f=i(3744);const g=(0,f.Z)(h,[["render",_],["__scopeId","data-v-402dbc26"]]);var k=g,w={name:"AlbumPart",components:{AlbumCard:k},props:{albums:Array}};const y=(0,f.Z)(w,[["render",d],["__scopeId","data-v-b74e26a0"]]);var x=y},4187:function(t,e,i){i.d(e,{Z:function(){return K}});var a=i(6252),s=i(3577),l=i(7737),n=i(9e3),r=i(8942),d=i(2716),u=i(584),o=i(6533),m=i(6719),c=i(3099),p=i(8676);const b=(0,o.U)({fixedHeader:Boolean,fixedFooter:Boolean,height:[Number,String],hover:Boolean,...(0,n.l)(),...(0,r.f)(),...(0,d.Q)(),...(0,u.x$)()},"VTable"),v=(0,m.ev)()({name:"VTable",props:b(),setup(t,e){let{slots:i}=e;const{themeClasses:s}=(0,u.ER)(t),{densityClasses:l}=(0,r.t)(t);return(0,c.L)((()=>(0,a.Wm)(t.tag,{class:["v-table",{"v-table--fixed-height":!!t.height,"v-table--fixed-header":t.fixedHeader,"v-table--fixed-footer":t.fixedFooter,"v-table--has-top":!!i.top,"v-table--has-bottom":!!i.bottom,"v-table--hover":t.hover},s.value,l.value,t.class],style:t.style},{default:()=>[i.top?.(),i.default?(0,a.Wm)("div",{class:"v-table__wrapper",style:{height:(0,p.kb)(t.height)}},[(0,a.Wm)("table",null,[i.default()])]):i.wrapper?.(),i.bottom?.()]}))),{}}}),_=t=>((0,a.dD)("data-v-6eee8946"),t=t(),(0,a.Cn)(),t),h={id:"content"},f={id:"head-table"},g=_((()=>(0,a._)("th",{class:"text-left",id:"head-table-music"},"Musique",-1))),k=_((()=>(0,a._)("th",{class:"text-left",id:"head-table-music"},"Album",-1))),w=_((()=>(0,a._)("th",{class:"text-left",id:"head-table-music"},null,-1))),y={class:"text-left",id:"head-table-music"},x=_((()=>(0,a._)("th",{class:"text-left",id:"head-table-music-para"},null,-1))),S={id:"colum-music"},W=["src"],L={id:"text-music"},C={id:"music-colum-music"},A={id:"artist-colum-music"},P={id:"play-button"},q={id:"time-row"},D=["src","onClick","id"],Z={id:"td-para"};function z(t,e,n,r,d,u){const o=(0,a.up)("router-link"),m=(0,a.up)("ParaSong");return(0,a.wg)(),(0,a.iD)("div",h,[(0,a.Wm)(v,{id:"table-music",color:"#3b4762",theme:"dark"},{default:(0,a.w5)((()=>[(0,a._)("thead",f,[(0,a._)("tr",null,[g,k,w,(0,a._)("th",y,[(0,a.Wm)(l.t,{icon:"mdi-clock-time-five-outline"})]),x])]),(0,a._)("tbody",null,[((0,a.wg)(!0),(0,a.iD)(a.HY,null,(0,a.Ko)(n.musics,(t=>((0,a.wg)(),(0,a.iD)("tr",{key:t.id,id:"row-music"},[(0,a._)("td",null,[(0,a._)("div",S,[(0,a._)("img",{src:t.photo,id:"img-pres"},null,8,W),(0,a._)("div",L,[(0,a._)("div",C,[(0,a._)("span",null,(0,s.zw)(t.name),1)]),(0,a._)("div",A,[(0,a.Wm)(o,{onClick:e[0]||(e[0]=t=>r.updateStore.update()),to:"/artist/"+t.artist.id,style:{"text-decoration":"none",color:"inherit"}},{default:(0,a.w5)((()=>[(0,a._)("span",null,(0,s.zw)(t.artist.name),1)])),_:2},1032,["to"])])]),(0,a._)("div",P,[(0,a.Wm)(l.t,{icon:"mdi-play",color:"#ead2ac",onClick:e=>r.cliquePlay(t.id)},null,8,["onClick"])])])]),(0,a._)("td",null,[(0,a.Wm)(o,{onClick:e[1]||(e[1]=t=>r.updateStore.update()),to:"/album/"+t.album.id,style:{"text-decoration":"none",color:"inherit"}},{default:(0,a.w5)((()=>[(0,a.Uk)((0,s.zw)(t.album.name)+(0,s.zw)(t.date),1)])),_:2},1032,["to"])]),(0,a._)("td",null,[(0,a._)("div",q,[(0,a._)("img",{src:i(7814),alt:"Picture of like",style:(0,s.j5)({filter:r.userStore.musiqueLike.includes(t.id)?"saturate(100%)":"saturate(0%)"}),onClick:e=>r.cliqueLike(t.id),id:t.id},null,12,D)])]),(0,a._)("td",null,(0,s.zw)(t.time),1),(0,a._)("td",Z,[(0,a.Wm)(m,{items:t.items,suppr:t.suppr,id:t.id,color:d.color},null,8,["items","suppr","id","color"])])])))),128))])])),_:1})])}var H=i(2262),M=i(6275),T=i(9068),U=i(408),F=i(2201),E=i(628),I={name:"TableMusic",components:{ParaSong:M.Z},setup(t){const e=(0,T.L)(),i=(0,U.u)(),a=(0,H.iH)(Array()),s=(0,F.yj)();t.musics.forEach((t=>{a.value[t.id]=e.musiqueLike.includes(t.id)}));const l=(0,H.iH)(Array(t.musics.length).fill(!1)),n=async i=>{e.musiqueLike.includes(i)?await e.dislike(i):await e.like(i),"like"===s.query.id&&t.musics.filter((t=>t.id!==i))},r=(0,E.J)(),d=function(e){const i=t.musics.find((t=>t.id===e)),a={img:i.photo,music:i.name,artist:i.artist.name,src:i.music};r.changeSong(a)};return{cliqueLike:n,like:a,isPlaying:l,userStore:e,updateStore:i,cliquePlay:d,musicStore:r}},props:{musics:Array},data(){return{color:"#b9d1db"}}},j=i(3744);const B=(0,j.Z)(I,[["render",z],["__scopeId","data-v-6eee8946"]]);var K=B},437:function(t,e,i){i.r(e),i.d(e,{default:function(){return q}});var a=i(6252),s=i(3577);const l={id:"artist-page"},n={id:"left-side"},r={key:0,id:"main-artist"},d={id:"top-main-content"},u={id:"top-artist-page"},o={id:"img-artist"},m=["src"],c={id:"artist-name"},p={id:"artist-content"},b={id:"artist-top-music"},v={id:"artist-album"};function _(t,e,i,_,h,f){const g=(0,a.up)("LeftMain"),k=(0,a.up)("UserTop"),w=(0,a.up)("TableMusic"),y=(0,a.up)("AlbumPart");return(0,a.wg)(),(0,a.iD)("div",l,[(0,a._)("div",n,[(0,a.Wm)(g)]),_.response.image?((0,a.wg)(),(0,a.iD)("div",r,[(0,a._)("div",d,[(0,a.Wm)(k)]),(0,a._)("div",u,[(0,a._)("div",o,[(0,a._)("img",{src:_.response.image},null,8,m)]),(0,a._)("div",c,[(0,a._)("span",null,(0,s.zw)(_.response.name),1)])]),(0,a._)("div",p,[(0,a._)("div",b,[(0,a.Wm)(w,{musics:_.response.bestSongs},null,8,["musics"])]),(0,a._)("div",v,[(0,a.Wm)(y,{albums:_.response.albums},null,8,["albums"])])])])):(0,a.kq)("",!0)])}var h=i(2882),f=i(4735),g=i(4187),k=i(6148),w=i(2262),y=i(2201),x=i(3002),S=i(1089),W=i(9068),L=i(408),C={setup(){const t=(0,S.l)(),e=(0,W.L)(),i=(0,L.u)(),s=(0,y.yj)(),l=(0,x.pm)(),n=(0,w.iH)({}),r=async()=>{if(!s.params.id)return s.push("/pagePrincipale"),void l.error("Erreur lors de la récupération de l'artiste : artiste inexistante");let i=await t.fetchArtist(s.params.id);n.value={id:i.id,name:i.name,image:i.image,bestSongs:[],albums:i.albums};for(let a of i.bestSongs){let i=[],s=[];i=await t.getPlaylistWithMusic(a.id),s=[],e.playlist.forEach((t=>s.push({id:t.id,name:t.name})));for(let t of i)s=s.filter((e=>e.id!==t.id));e.musiqueLike.includes(a.id)?i.push({id:"like",name:"Favoris"}):s.push({id:"like",name:"Favoris"}),n.value.bestSongs.push({id:a.id,name:a.name,artist:a.artist,album:a.album,time:a.time,items:s,suppr:i,photo:a.photo,music:a.music,nbLikes:a.nbLikes})}};return(0,a.vl)((async()=>{await r()})),(0,a.wF)((async()=>{await r()})),{response:n,updateStore:i}},name:"ArtistPage",components:{LeftMain:f.Z,UserTop:k.Z,TableMusic:g.Z,AlbumPart:h.Z}},A=i(3744);const P=(0,A.Z)(C,[["render",_],["__scopeId","data-v-7ac0d011"]]);var q=P}}]);
//# sourceMappingURL=artist.c39938cf.js.map