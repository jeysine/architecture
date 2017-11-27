package cn.com.architecture.wechat.entity.message;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WechatMessage implements Serializable{
	private static final long serialVersionUID = 5822867437318610516L;
	/**
	 * 用户openid
	 */
	@JsonProperty("touser")
	private String touser;
	/**
	 * 消息类型
	 */
	@JsonProperty("msgtype")
	private String msgtype;

	@JsonProperty("text")
	private Text text;

	@JsonProperty("image")
	private Image image;

	@JsonProperty("voice")
	private Voice voice;

	@JsonProperty("video")
	private Video video;

	@JsonProperty("music")
	private Music music;

	@JsonProperty("news")
	private News news;

	@JsonProperty("mpnews")
	private Mpnews mpnews;

	@JsonProperty("wxcard")
	private Wxcard wxcard;

	class Text {
		@JsonProperty("content")
		private String content;

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}
	}

	public class Image {
		@JsonProperty("media_id")
		private String mediaId;

		public String getMediaId() {
			return mediaId;
		}

		public void setMediaId(String mediaId) {
			this.mediaId = mediaId;
		}
	}

	public class Voice {
		@JsonProperty("media_id")
		private String mediaId;

		public String getMediaId() {
			return mediaId;
		}

		public void setMediaId(String mediaId) {
			this.mediaId = mediaId;
		}
	}

	public class Video {
		@JsonProperty("media_id")
		private String mediaId;
		@JsonProperty("thumb_media_id")
		private String thumbMediaId;
		@JsonProperty("title")
		private String title;
		@JsonProperty("description")
		private String description;

	}

	public class Music {
		@JsonProperty("title")
		private String title;
		@JsonProperty("description")
		private String description;
		@JsonProperty("musicurl")
		private String musicurl;
		@JsonProperty("hqmusicurl")
		private String hqmusicurl;
		@JsonProperty("thumb_media_id")
		private String thumbMediaId;

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getMusicurl() {
			return musicurl;
		}

		public void setMusicurl(String musicurl) {
			this.musicurl = musicurl;
		}

		public String getHqmusicurl() {
			return hqmusicurl;
		}

		public void setHqmusicurl(String hqmusicurl) {
			this.hqmusicurl = hqmusicurl;
		}

		public String getThumbMediaId() {
			return thumbMediaId;
		}

		public void setThumbMediaId(String thumbMediaId) {
			this.thumbMediaId = thumbMediaId;
		}
	}

	public class News{
		private List<Articl> articles;

		public class Articl {
			@JsonProperty("title")
			private String title;
			@JsonProperty("description")
			private String description;
			@JsonProperty("url")
			private String url;
			@JsonProperty("picurl")
			private String picurl;

			public String getTitle() {
				return title;
			}

			public void setTitle(String title) {
				this.title = title;
			}

			public String getDescription() {
				return description;
			}

			public void setDescription(String description) {
				this.description = description;
			}

			public String getUrl() {
				return url;
			}

			public void setUrl(String url) {
				this.url = url;
			}

			public String getPicurl() {
				return picurl;
			}

			public void setPicurl(String picurl) {
				this.picurl = picurl;
			}
		}

		public List<Articl> getArticles() {
			return articles;
		}

		public void setArticles(List<Articl> articles) {
			this.articles = articles;
		}
	}


	public class Mpnews {
		@JsonProperty("media_id")
		private String mediaId;

		public String getMediaId() {
			return mediaId;
		}

		public void setMediaId(String mediaId) {
			this.mediaId = mediaId;
		}
	}

	public class Wxcard {
		@JsonProperty("card_id")
		private String cardId;

		public String getCardId() {
			return cardId;
		}

		public void setCardId(String cardId) {
			this.cardId = cardId;
		}
	}
	public String getTouser() {
		return touser;
	}

	public void setTouser(String touser) {
		this.touser = touser;
	}

	public String getMsgtype() {
		return msgtype;
	}

	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}

	public Text getText() {
		return text;
	}

	public void setText(Text text) {
		this.text = text;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public Voice getVoice() {
		return voice;
	}

	public void setVoice(Voice voice) {
		this.voice = voice;
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	public Music getMusic() {
		return music;
	}

	public void setMusic(Music music) {
		this.music = music;
	}

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

	public Mpnews getMpnews() {
		return mpnews;
	}

	public void setMpnews(Mpnews mpnews) {
		this.mpnews = mpnews;
	}

	public Wxcard getWxcard() {
		return wxcard;
	}

	public void setWxcard(Wxcard wxcard) {
		this.wxcard = wxcard;
	}
}
