package com.reactive.wexfluxmysql;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;


@SpringBootTest
class WexfluxMysqlApplicationTests {

	@Test
	void test1() {
		Mono<String> stringMono= Mono.just("akshay").log();
		stringMono.subscribe(System.out::println);
	}
	@Test
	void test2() {
		Flux<String> fluxData =Flux.just("akshay","anumitha","kannan").log();
		fluxData.subscribe(System.out::println);

	}
	@Test
	void test3() {

		Flux<String> fluxData =Flux.just("akshay","anumitha","kannan").log()
		.concatWithValues("Chinnu")
		.concatWith(Flux.error(new Exception("exptionnnnnn")))
		.concatWithValues("Chinnu");
		fluxData.subscribe(System.out::println);

	}
	@Test
	void test4() {
		Flux<String> fluxData = Flux.just("akshay","anumitha","kannan").map(String::toUpperCase).log();
		fluxData.subscribe(System.out::println);
		Flux<String> fluxFilterData = Flux.just("akshay","anumitha","kannan").filter(s->s.length()>=8);
        System.out.println("-----------------------------------------------------");
		fluxFilterData.subscribe(System.out::println);
	}
	@Test
	void test5() {

		Function<Flux<String>,Flux<String>> filter=data -> data.filter(s->s.length()>6);
		Flux<String> fluxData = Flux.just("akshay","anumitha","kannan")
				.transform(filter);
		fluxData.subscribe(System.out::println);


	}
	@Test
	void test6() {

		Function<Flux<String>,Flux<String>> filter=data -> data.filter(s->s.length()>9);
		Flux<String> fluxData = Flux.just("akshay","anumitha","kannan")
				.transform(filter)
				.defaultIfEmpty( "Default");
		fluxData.subscribe(System.out::println);
	}
	@Test
	void test7() {
		Flux<String> fluxData1 = Flux.just("a","c","e").delayElements(Duration.ofMillis(1));
		Flux<String> fluxData2 = Flux.just("b","d","f").delayElements(Duration.ofMillis(1));
		Flux<String> concat=Flux.concat(fluxData1,fluxData2);

		Flux<String> merge=Flux.merge(fluxData1,fluxData2).log();
		Flux<String> mergeSeq=Flux.mergeSequential(fluxData1,fluxData2).log();
		//Flux<String> smerge=Flux.mergeSequential(fluxData1,fluxData2);
		//Flux<String> concatWith=fluxData1.concatWith(fluxData2).log();
		mergeSeq.subscribe(System.out::println);

	}
	@Test
	void test8() {
		Flux<String> fluxData1 = Flux.just("a","c","e");
		Flux<String> fluxData2 = Flux.just("b","d","f");
		Flux<String> res =Flux.zip(fluxData1,fluxData2,(first,second) ->first+second).log();
		res.subscribe(System.out::println);

	}
	@Test
	void test9() {

//		List<Books> booklist= Arrays.asList(
//				new Books(1,"book1","Author1"),
//				new Books(2,"book2","Author2"),
//				new Books(3,"book3","Author3")
//		);
//		List<Reviews> reviewsList=Arrays.asList(
//				new Reviews(1,9.3,"Good book"),
//				new Reviews(2,9.1,"Nice book")
//		);
		Mono<Books> booksFlux=Mono.just(new Books(1,"book1","Author1"));
		Mono<Reviews> reviewsFlux= Mono.just(new Reviews(1,9.3,"Good book"));
		Mono<List<Reviews>> listReview=Mono.just(Arrays.asList(new Reviews(1,9.3,"Good book")));

		Mono<Tuple2<Books,Reviews>> res= booksFlux.zipWith(reviewsFlux).log();

		//res.subscribe(System.out::println);
		Mono<BookInfo>  res2= booksFlux.zipWith(listReview,(b,r)-> new BookInfo(b,r));
		res2.subscribe(System.out::println);

	}


}
