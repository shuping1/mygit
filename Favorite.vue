<template>
	<div>
			<div class="container">
				<div class="row">
					<div class="banner">
							<svg class="Zi Zi--Star" fill="currentColor" viewBox="0 0 24 24" width="36" height="36" style="fill: #0084FF; margin-right: 20px;">
								<path d="M5.515 19.64l.918-5.355-3.89-3.792c-.926-.902-.639-1.784.64-1.97L8.56 7.74l2.404-4.871c.572-1.16 1.5-1.16 2.072 0L15.44 7.74l5.377.782c1.28.186 1.566 1.068.64 1.97l-3.89 3.793.918 5.354c.219 1.274-.532 1.82-1.676 1.218L12 18.33l-4.808 2.528c-1.145.602-1.896.056-1.677-1.218z" fill-rule="evenodd"></path>
							</svg>
							<h3>热门收藏夹</h3>
					</div>
					<div class="col-12 box " v-for="(item,index)  in favorites" v-if="index>begin&&index<end" :key="index">
							<div class="fav flex">
								<div class="a-left">
									<p class="title" >{{item.title}}</p>
									<div class="flex" >
										<img :src="item.creator_avatar" alt=""  class="creator_avatar" >
										<p>{{item.creator_name}}</p>
										<p class="create" >创建</p>
									</div>
									<div class="flex"  >
										<button class="btn_gz">关注收藏夹</button>
										<p class="followers" >{{item.followers}}人关注</p>
									</div>		
								</div>
								<div class="a-right flex">
									<div>
										<p class="question_title" >{{item.question_title}}</p>
										<p class="answer" >{{item.answer_author_name}}: {{item.answer_content.slice(0,30) }}...</p>
									</div>
									<div class="flex" style="margin-top: 10px; margin-bottom: 10px; width: 100%;">
										<span style="height: 20px;line-height: 20px;padding: 0 4px;background-color: #f6f6f6;color: #999;font-size: 12px;margin-right: 8px;">文章</span>
										<p style="height: 17px; font-size: 12px; color: #999999;margin-right: 5px;">{{item.voteup_count}}赞同</p>
										<p style="height: 17px; font-size: 12px; color: #999999;">{{item.comment_count}}评论</p>
									</div>
									<div>
										<p style="align-items: center;margin-top: 20px;height: 24px;font-size: 14px;color: #8590a6;font-weight: 600;">已收藏{{item.total_count}}条内容  ></p>
									 </div>
								</div>
							</div>
						</div>
						 <button @click="show_all" class="flex center btn_gz">展开全部>>></button>
				</div>
				<div><a href="#top"  class="top"><i class="iconfont">&#xe723;</i></a></div>
			</div>
	</div>

</template>


<script>
	export default{
		name:'favorite',
		data(){
			return{
				favorites:[],
				begin:0,
				end:6,
			};
		},
		created() {
			this.axios.get('http://localhost:8080/zhihu/favorite/all').then(res =>{
				console.log(res);
				this.favorites = res.data.data;
			});
		},
		methods: {
		show_all(){
		this.begin=0;
		this.end =this.favorites.length;
		}						
		},					
	};
</script>

<style>
	.banner{
	width: 100%;
	margin-bottom: 10px;
	margin-top: 10px;
	height: 80px;
	display: flex;
	align-items: center;
	font-size: 20px;
	}
	 
	.fav{
		padding: 24px;
        width: 1000px;
		height: 179px;
		background-color: #fff;
		-webkit-box-shadow: 0 1px 3px 0 rgba(26,26,26,.1);
		box-shadow: 0 1px 3px 0 rgba(26,26,26,.1);
		margin-bottom: 10px;
	}
	.a-left{
		width: 30%;
	}
	.a-right{
		width: 70%;
	}
	.box{
		display: flex;
		width: 100%;
		height: 240px;
		margin-bottom: 20px;
		padding: 25px;
		background-color: white;
		border-radius: 6px;
	}
	.title{
		height: 24px;
		font-size: 16px; 
		font-weight: 600;
	}
	.flex{
		margin-top:10px;
		padding-top: 5px;
		
	}
	.creator_avatar{
		 width: 30px;
		 height: 30px; 
		 margin: 5px;
	}
	.create{
		height: 21px;
		 font-size: 14px;
		 color: #999999;
		 margin-left: 5px;
	}
	.followers{
		 margin-left: 16px;
		 font-size: 14px;
		 color: #999999;
	}
	.question_title{
		 line-height: 21px;
		  font-weight: 600;
	}
	.answer{
		margin-top: 4px;
		height: 21px;
		line-height: 21px;
		color: #444;
		white-space: nowrap;
	}
	.iconfont{
		font-size: 30px;
		color: #0084FF;
	}
	.top{
	position: fixed;
	 bottom: 5%;
	  right: 5%;
	}
</style>