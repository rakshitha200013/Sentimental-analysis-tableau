library(rvest)
library(dplyr)


link = "https://www.imdb.com/search/title/?groups=top_250&sort=user_rating"
page = read_html(link)

name = page %>% html_nodes(".lister-item-header a") %>% html_text()
year = page %>% html_nodes(".text-muted.unbold") %>% html_text()
rating = page %>% html_nodes(".ratings-imdb-rating strong") %>% html_text()
synopsis = page %>% html_nodes(".ratings-bar+ .text-muted") %>% html_text()

movies = data.frame(name, year, rating, synopsis, stringsAsFactors = FALSE)
write.csv(movies, "movies.csv")

View(movies)

install.packages("syuzhet")
library(syuzhet)

link = "https://www.imdb.com/title/tt0810913/reviews?ref_=tt_urv"
page = read_html(link)

review = page %>% html_nodes(".show-more__control") %>% html_text()
Review = data.frame(review, stringsAsFactors = FALSE)
write.csv(Review, "Review.csv")

View(Review)

text_df <-read.csv("Review.csv",stringsAsFactors = FALSE)
 
review <- as.character(text_df$review)

get_nrc_sentiment('happy')
get_nrc_sentiment('sad')



s <- get_nrc_sentiment(review)

review_sentiment <- cbind(text_df$review,s)

barplot(colSums(s),col=rainbow(10),ylab='Count',main='Sentiment scores for movie review')

#second movie

library(syuzhet)

link = "https://www.imdb.com/title/tt7838252/reviews?ref_=tt_urv"
page = read_html(link)

review1 = page %>% html_nodes(".show-more__control") %>% html_text()
Review1 = data.frame(review1, stringsAsFactors = FALSE)
write.csv(Review1, "Review1.csv")

View(Review1)

text_df <-read.csv("Review1.csv",stringsAsFactors = FALSE)

review1 <- as.character(text_df$review1)

get_nrc_sentiment('happy')
get_nrc_sentiment('sad')

s <- get_nrc_sentiment(review1)

review_sentiment <- cbind(text_df$review1,s)

barplot(colSums(s),col=rainbow(10),ylab='Count',main='Sentiment scores for movie review')