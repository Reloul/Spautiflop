"use strict";(self["webpackChunktest"]=self["webpackChunktest"]||[]).push([[985],{4187:function(e,t,i){i.d(t,{Z:function(){return V}});var a=i(6252),s=i(3577),l=i(7737),n=i(9e3),u=i(8942),o=i(2716),d=i(584),r=i(6533),c=i(6719),m=i(3099),p=i(8676);const h=(0,r.U)({fixedHeader:Boolean,fixedFooter:Boolean,height:[Number,String],hover:Boolean,...(0,n.l)(),...(0,u.f)(),...(0,o.Q)(),...(0,d.x$)()},"VTable"),v=(0,c.ev)()({name:"VTable",props:h(),setup(e,t){let{slots:i}=t;const{themeClasses:s}=(0,d.ER)(e),{densityClasses:l}=(0,u.t)(e);return(0,m.L)((()=>(0,a.Wm)(e.tag,{class:["v-table",{"v-table--fixed-height":!!e.height,"v-table--fixed-header":e.fixedHeader,"v-table--fixed-footer":e.fixedFooter,"v-table--has-top":!!i.top,"v-table--has-bottom":!!i.bottom,"v-table--hover":e.hover},s.value,l.value,e.class],style:e.style},{default:()=>[i.top?.(),i.default?(0,a.Wm)("div",{class:"v-table__wrapper",style:{height:(0,p.kb)(e.height)}},[(0,a.Wm)("table",null,[i.default()])]):i.wrapper?.(),i.bottom?.()]}))),{}}}),f=e=>((0,a.dD)("data-v-6eee8946"),e=e(),(0,a.Cn)(),e),b={id:"content"},_={id:"head-table"},g=f((()=>(0,a._)("th",{class:"text-left",id:"head-table-music"},"Musique",-1))),k=f((()=>(0,a._)("th",{class:"text-left",id:"head-table-music"},"Album",-1))),w=f((()=>(0,a._)("th",{class:"text-left",id:"head-table-music"},null,-1))),y={class:"text-left",id:"head-table-music"},x=f((()=>(0,a._)("th",{class:"text-left",id:"head-table-music-para"},null,-1))),S={id:"colum-music"},W=["src"],L={id:"text-music"},q={id:"music-colum-music"},C={id:"artist-colum-music"},z={id:"play-button"},P={id:"time-row"},H=["src","onClick","id"],M={id:"td-para"};function T(e,t,n,u,o,d){const r=(0,a.up)("router-link"),c=(0,a.up)("ParaSong");return(0,a.wg)(),(0,a.iD)("div",b,[(0,a.Wm)(v,{id:"table-music",color:"#3b4762",theme:"dark"},{default:(0,a.w5)((()=>[(0,a._)("thead",_,[(0,a._)("tr",null,[g,k,w,(0,a._)("th",y,[(0,a.Wm)(l.t,{icon:"mdi-clock-time-five-outline"})]),x])]),(0,a._)("tbody",null,[((0,a.wg)(!0),(0,a.iD)(a.HY,null,(0,a.Ko)(n.musics,(e=>((0,a.wg)(),(0,a.iD)("tr",{key:e.id,id:"row-music"},[(0,a._)("td",null,[(0,a._)("div",S,[(0,a._)("img",{src:e.photo,id:"img-pres"},null,8,W),(0,a._)("div",L,[(0,a._)("div",q,[(0,a._)("span",null,(0,s.zw)(e.name),1)]),(0,a._)("div",C,[(0,a.Wm)(r,{onClick:t[0]||(t[0]=e=>u.updateStore.update()),to:"/artist/"+e.artist.id,style:{"text-decoration":"none",color:"inherit"}},{default:(0,a.w5)((()=>[(0,a._)("span",null,(0,s.zw)(e.artist.name),1)])),_:2},1032,["to"])])]),(0,a._)("div",z,[(0,a.Wm)(l.t,{icon:"mdi-play",color:"#ead2ac",onClick:t=>u.cliquePlay(e.id)},null,8,["onClick"])])])]),(0,a._)("td",null,[(0,a.Wm)(r,{onClick:t[1]||(t[1]=e=>u.updateStore.update()),to:"/album/"+e.album.id,style:{"text-decoration":"none",color:"inherit"}},{default:(0,a.w5)((()=>[(0,a.Uk)((0,s.zw)(e.album.name)+(0,s.zw)(e.date),1)])),_:2},1032,["to"])]),(0,a._)("td",null,[(0,a._)("div",P,[(0,a._)("img",{src:i(7814),alt:"Picture of like",style:(0,s.j5)({filter:u.userStore.musiqueLike.includes(e.id)?"saturate(100%)":"saturate(0%)"}),onClick:t=>u.cliqueLike(e.id),id:e.id},null,12,H)])]),(0,a._)("td",null,(0,s.zw)(e.time),1),(0,a._)("td",M,[(0,a.Wm)(c,{items:e.items,suppr:e.suppr,id:e.id,color:o.color},null,8,["items","suppr","id","color"])])])))),128))])])),_:1})])}var Z=i(2262),A=i(6275),D=i(9068),F=i(408),E=i(2201),U=i(628),j={name:"TableMusic",components:{ParaSong:A.Z},setup(e){const t=(0,D.L)(),i=(0,F.u)(),a=(0,Z.iH)(Array()),s=(0,E.yj)();e.musics.forEach((e=>{a.value[e.id]=t.musiqueLike.includes(e.id)}));const l=(0,Z.iH)(Array(e.musics.length).fill(!1)),n=async i=>{t.musiqueLike.includes(i)?await t.dislike(i):await t.like(i),"like"===s.query.id&&e.musics.filter((e=>e.id!==i))},u=(0,U.J)(),o=function(t){const i=e.musics.find((e=>e.id===t)),a={img:i.photo,music:i.name,artist:i.artist.name,src:i.music};u.changeSong(a)};return{cliqueLike:n,like:a,isPlaying:l,userStore:t,updateStore:i,cliquePlay:o,musicStore:u}},props:{musics:Array},data(){return{color:"#b9d1db"}}},B=i(3744);const I=(0,B.Z)(j,[["render",T],["__scopeId","data-v-6eee8946"]]);var V=I},6290:function(e,t,i){i.r(t),i.d(t,{default:function(){return P}});var a=i(6252),s=i(3577);const l={id:"album-page"},n={id:"left-side"},u={key:0,id:"main-album"},o={id:"top-main-content"},d={id:"album-content"},r={id:"top-content-album"},c={id:"picture"},m=["src"],p={id:"text"},h={id:"name"},v={id:"user"},f={id:"music"};function b(e,t,i,b,_,g){const k=(0,a.up)("LeftMain"),w=(0,a.up)("UserTop"),y=(0,a.up)("router-link"),x=(0,a.up)("TableMusic");return(0,a.wg)(),(0,a.iD)("div",l,[(0,a._)("div",n,[(0,a.Wm)(k)]),b.response.image?((0,a.wg)(),(0,a.iD)("div",u,[(0,a._)("div",o,[(0,a.Wm)(w)]),(0,a._)("div",d,[(0,a._)("div",r,[(0,a._)("div",c,[(0,a._)("img",{src:b.response.image},null,8,m)]),(0,a._)("div",p,[(0,a._)("div",h,[(0,a._)("span",null,(0,s.zw)(b.response.name),1)]),(0,a._)("div",v,[(0,a.Wm)(y,{to:"/artist/"+b.response.artist.id,style:{"text-decoration":"none",color:"inherit"},onClick:t[0]||(t[0]=e=>b.updateStore.update())},{default:(0,a.w5)((()=>[(0,a._)("span",null,(0,s.zw)(b.response.artist.name),1)])),_:1},8,["to"]),(0,a._)("span",null,(0,s.zw)(-b.response.date)+" - ",1),(0,a._)("span",null,(0,s.zw)(b.nbSong)+" musiques",1)])])]),(0,a._)("div",f,[(0,a.Wm)(x,{musics:b.response.songs},null,8,["musics"])])])])):(0,a.kq)("",!0)])}var _=i(4735),g=i(4187),k=i(6148),w=i(2262),y=i(2201),x=i(3002),S=i(1089),W=i(9068),L=i(408),q={setup(){const e=(0,S.l)(),t=(0,W.L)(),i=(0,L.u)(),s=(0,y.yj)(),l=(0,x.pm)(),n=(0,w.iH)({}),u=(0,w.iH)(0),o=async()=>{if(!s.params.id)return s.push("/pagePrincipale"),void l.error("Erreur lors de la récupération de la playlist : playlist inexistante");let i=await e.fetchAlbum(s.params.id);n.value={id:i.id,name:i.name,artist:i.artist,date:i.date,image:i.image,songs:[]};for(let a of i.songs){let i=[],s=[];i=await e.getPlaylistWithMusic(a.id),s=[],t.playlist.forEach((e=>s.push({id:e.id,name:e.name})));for(let e of i)s=s.filter((t=>t.id!==e.id));t.musiqueLike.includes(a.id)?i.push({id:"like",name:"Favoris"}):s.push({id:"like",name:"Favoris"}),n.value.songs.push({id:a.id,name:a.name,artist:a.artist,album:a.album,time:a.time,items:s,suppr:i,photo:a.photo,music:a.music,nbLikes:a.nbLikes})}u.value=n.value.songs.length};return(0,a.vl)((async()=>{await o()})),(0,a.wF)((async()=>{await o()})),{response:n,nbSong:u,updateStore:i}},name:"AlbumPage",components:{LeftMain:_.Z,TableMusic:g.Z,UserTop:k.Z}},C=i(3744);const z=(0,C.Z)(q,[["render",b],["__scopeId","data-v-6833f65e"]]);var P=z}}]);
//# sourceMappingURL=album.aac972ba.js.map