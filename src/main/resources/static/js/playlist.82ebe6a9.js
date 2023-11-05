"use strict";(self["webpackChunktest"]=self["webpackChunktest"]||[]).push([[449],{4187:function(e,i,t){t.d(i,{Z:function(){return V}});var a=t(6252),l=t(3577),s=t(7737),u=t(9e3),n=t(8942),d=t(2716),o=t(584),r=t(6533),c=t(6719),m=t(3099),p=t(8676);const v=(0,r.U)({fixedHeader:Boolean,fixedFooter:Boolean,height:[Number,String],hover:Boolean,...(0,u.l)(),...(0,n.f)(),...(0,d.Q)(),...(0,o.x$)()},"VTable"),h=(0,c.ev)()({name:"VTable",props:v(),setup(e,i){let{slots:t}=i;const{themeClasses:l}=(0,o.ER)(e),{densityClasses:s}=(0,n.t)(e);return(0,m.L)((()=>(0,a.Wm)(e.tag,{class:["v-table",{"v-table--fixed-height":!!e.height,"v-table--fixed-header":e.fixedHeader,"v-table--fixed-footer":e.fixedFooter,"v-table--has-top":!!t.top,"v-table--has-bottom":!!t.bottom,"v-table--hover":e.hover},l.value,s.value,e.class],style:e.style},{default:()=>[t.top?.(),t.default?(0,a.Wm)("div",{class:"v-table__wrapper",style:{height:(0,p.kb)(e.height)}},[(0,a.Wm)("table",null,[t.default()])]):t.wrapper?.(),t.bottom?.()]}))),{}}}),f=e=>((0,a.dD)("data-v-6eee8946"),e=e(),(0,a.Cn)(),e),_={id:"content"},b={id:"head-table"},g=f((()=>(0,a._)("th",{class:"text-left",id:"head-table-music"},"Musique",-1))),k=f((()=>(0,a._)("th",{class:"text-left",id:"head-table-music"},"Album",-1))),y=f((()=>(0,a._)("th",{class:"text-left",id:"head-table-music"},null,-1))),w={class:"text-left",id:"head-table-music"},x=f((()=>(0,a._)("th",{class:"text-left",id:"head-table-music-para"},null,-1))),S={id:"colum-music"},L=["src"],W={id:"text-music"},q={id:"music-colum-music"},C={id:"artist-colum-music"},H={id:"play-button"},P={id:"time-row"},z=["src","onClick","id"],M={id:"td-para"};function T(e,i,u,n,d,o){const r=(0,a.up)("router-link"),c=(0,a.up)("ParaSong");return(0,a.wg)(),(0,a.iD)("div",_,[(0,a.Wm)(h,{id:"table-music",color:"#3b4762",theme:"dark"},{default:(0,a.w5)((()=>[(0,a._)("thead",b,[(0,a._)("tr",null,[g,k,y,(0,a._)("th",w,[(0,a.Wm)(s.t,{icon:"mdi-clock-time-five-outline"})]),x])]),(0,a._)("tbody",null,[((0,a.wg)(!0),(0,a.iD)(a.HY,null,(0,a.Ko)(u.musics,(e=>((0,a.wg)(),(0,a.iD)("tr",{key:e.id,id:"row-music"},[(0,a._)("td",null,[(0,a._)("div",S,[(0,a._)("img",{src:e.photo,id:"img-pres"},null,8,L),(0,a._)("div",W,[(0,a._)("div",q,[(0,a._)("span",null,(0,l.zw)(e.name),1)]),(0,a._)("div",C,[(0,a.Wm)(r,{onClick:i[0]||(i[0]=e=>n.updateStore.update()),to:"/artist/"+e.artist.id,style:{"text-decoration":"none",color:"inherit"}},{default:(0,a.w5)((()=>[(0,a._)("span",null,(0,l.zw)(e.artist.name),1)])),_:2},1032,["to"])])]),(0,a._)("div",H,[(0,a.Wm)(s.t,{icon:"mdi-play",color:"#ead2ac",onClick:i=>n.cliquePlay(e.id)},null,8,["onClick"])])])]),(0,a._)("td",null,[(0,a.Wm)(r,{onClick:i[1]||(i[1]=e=>n.updateStore.update()),to:"/album/"+e.album.id,style:{"text-decoration":"none",color:"inherit"}},{default:(0,a.w5)((()=>[(0,a.Uk)((0,l.zw)(e.album.name)+(0,l.zw)(e.date),1)])),_:2},1032,["to"])]),(0,a._)("td",null,[(0,a._)("div",P,[(0,a._)("img",{src:t(7814),alt:"Picture of like",style:(0,l.j5)({filter:n.userStore.musiqueLike.includes(e.id)?"saturate(100%)":"saturate(0%)"}),onClick:i=>n.cliqueLike(e.id),id:e.id},null,12,z)])]),(0,a._)("td",null,(0,l.zw)(e.time),1),(0,a._)("td",M,[(0,a.Wm)(c,{items:e.items,suppr:e.suppr,id:e.id,color:d.color},null,8,["items","suppr","id","color"])])])))),128))])])),_:1})])}var Z=t(2262),F=t(6275),D=t(9068),A=t(408),U=t(2201),j=t(628),B={name:"TableMusic",components:{ParaSong:F.Z},setup(e){const i=(0,D.L)(),t=(0,A.u)(),a=(0,Z.iH)(Array()),l=(0,U.yj)();e.musics.forEach((e=>{a.value[e.id]=i.musiqueLike.includes(e.id)}));const s=(0,Z.iH)(Array(e.musics.length).fill(!1)),u=async t=>{i.musiqueLike.includes(t)?await i.dislike(t):await i.like(t),"like"===l.query.id&&e.musics.filter((e=>e.id!==t))},n=(0,j.J)(),d=function(i){const t=e.musics.find((e=>e.id===i)),a={img:t.photo,music:t.name,artist:t.artist.name,src:t.music};n.changeSong(a)};return{cliqueLike:u,like:a,isPlaying:s,userStore:i,updateStore:t,cliquePlay:d,musicStore:n}},props:{musics:Array},data(){return{color:"#b9d1db"}}},E=t(3744);const I=(0,E.Z)(B,[["render",T],["__scopeId","data-v-6eee8946"]]);var V=I},2736:function(e,i,t){t.r(i),t.d(i,{default:function(){return H}});var a=t(6252),l=t(3577);const s={id:"playlist-page"},u={id:"left-side"},n={id:"main-playlist"},d={id:"top-main-content"},o={id:"playlist-content"},r={id:"top-content-playlist"},c={id:"picture"},m=["src"],p={id:"text"},v={id:"name"},h={id:"user"},f={id:"music"};function _(e,i,t,_,b,g){const k=(0,a.up)("LeftMain"),y=(0,a.up)("UserTop"),w=(0,a.up)("TableMusic");return(0,a.wg)(),(0,a.iD)("div",s,[(0,a._)("div",u,[(0,a.Wm)(k)]),(0,a._)("div",n,[(0,a._)("div",d,[(0,a.Wm)(y)]),(0,a._)("div",o,[(0,a._)("div",r,[(0,a._)("div",c,[(0,a._)("img",{src:_.image,alt:""},null,8,m)]),(0,a._)("div",p,[(0,a._)("div",v,[(0,a._)("span",null,(0,l.zw)(_.name),1)]),(0,a._)("div",h,[(0,a._)("span",null,(0,l.zw)(_.userStore.pseudo)+" - ",1),(0,a._)("span",null,(0,l.zw)(_.nbSong)+" musiques",1)])])]),(0,a._)("div",f,[(0,a.Wm)(w,{musics:_.response},null,8,["musics"])])])])])}var b=t(4735),g=t(6148),k=t(4187),y=t(2262),w=t(2201),x=t(9068),S=t(1089),L=t(408),W={setup(){const e=(0,x.L)(),i=(0,S.l)(),l=(0,L.u)(),s=(0,w.yj)(),u=(0,y.iH)([]),n=(0,y.iH)(0),d=(0,y.iH)(""),o=(0,y.iH)(""),r=async()=>{let a;"like"!=s.params.id?(a=await e.getPlaylist(s.params.id),o.value=a.image):(a=await e.getFavoris(),o.value=t(7814)),d.value=a.name;for(let t of a.musique){let a=[],l=[];a=await i.getPlaylistWithMusic(t.id),l=[],e.playlist.forEach((e=>l.push({id:e.id,name:e.name})));for(let e of a)l=l.filter((i=>i.id!==e.id));e.musiqueLike.includes(t.id)?a.push({id:"like",name:"Favoris"}):l.push({id:"like",name:"Favoris"}),u.value.push({id:t.id,name:t.name,artist:t.artist,album:t.album,time:t.time,items:l,suppr:a,photo:t.photo,music:t.music,nbLikes:t.nbLikes})}n.value=u.value.length};return(0,a.wF)((async()=>{u.value=[],await r()})),{response:u,nbSong:n,userStore:e,name:d,image:o,nbSong:n,updateStore:l}},name:"MaPlaylist",components:{LeftMain:b.Z,UserTop:g.Z,TableMusic:k.Z}},q=t(3744);const C=(0,q.Z)(W,[["render",_],["__scopeId","data-v-457a414c"]]);var H=C}}]);
//# sourceMappingURL=playlist.82ebe6a9.js.map