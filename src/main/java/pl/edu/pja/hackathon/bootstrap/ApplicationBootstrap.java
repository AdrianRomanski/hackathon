package pl.edu.pja.hackathon.bootstrap;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pl.edu.pja.hackathon.model.Category;
import pl.edu.pja.hackathon.model.memocard.MemoCard;
import pl.edu.pja.hackathon.repositories.CategoryRepository;
import pl.edu.pja.hackathon.repositories.MemoCardRepository;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Component
@AllArgsConstructor
public class ApplicationBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final CategoryRepository categoryRepository;
    private final MemoCardRepository memoCardRepository;

    @Override
    @SneakyThrows
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        Byte[] horrorImage = getBytes("src/main/resources/static/pictures/kiwi_oil.jpg");

        // Categories
        Category colors = Category.builder().name("Kolory").image(horrorImage).build();
        Category countries = Category.builder().name("Państwa").image(horrorImage).build();
        Category furniture = Category.builder().name("Meble").image(horrorImage).build();
        Category animals = Category.builder().name("Zwierzęta").image(horrorImage).build();
        Category family = Category.builder().name("Rodzina").image(horrorImage).build();
        Category buildings = Category.builder().name("Budynki").image(horrorImage).build();
        Category food = Category.builder().name("Jedzenie").image(horrorImage).build();
        Category vehicles = Category.builder().name("Pojazdy").image(horrorImage).build();
        Category items = Category.builder().name("Przedmioty").image(horrorImage).build();
        Category cities = Category.builder().name("Miasta").image(horrorImage).build();
        Category weather = Category.builder().name("Pogoda").image(horrorImage).build();
        Category work = Category.builder().name("Praca").image(horrorImage).build();
        Category drinks = Category.builder().name("Napoje").image(horrorImage).build();

        categoryRepository.saveAll(Arrays.asList(colors, countries, furniture, animals, family, buildings, food, vehicles, items, cities, weather, work, drinks));

        // Colors
        MemoCard black = MemoCard.builder().name("black").definition("czarny").category(colors).build();
        MemoCard white = MemoCard.builder().name("white").definition("biały").category(colors).build();
        MemoCard orange = MemoCard.builder().name("orange").definition("pomarańczowy").category(colors).build();
        MemoCard red = MemoCard.builder().name("red").definition("czerwony").category(colors).build();
        MemoCard blue = MemoCard.builder().name("blue").definition("niebieski").category(colors).build();
        MemoCard grey = MemoCard.builder().name("grey").definition("szary").category(colors).build();
        MemoCard pink = MemoCard.builder().name("pink").definition("różowy").category(colors).build();
        MemoCard brown = MemoCard.builder().name("brown").definition("brązowy").category(colors).build();
        MemoCard yellow = MemoCard.builder().name("yellow").definition("żółty").category(colors).build();

        List<MemoCard> colorMemoCards = Arrays.asList(black, white, orange, red, blue, grey, pink, brown, yellow);
        memoCardRepository.saveAll(colorMemoCards);
        colors.setMemoCardList(colorMemoCards);
        categoryRepository.save(colors);

        // Countries
        MemoCard poland = MemoCard.builder().name("Poland").definition("Polska").category(countries).build();
        MemoCard germany = MemoCard.builder().name("Germany").definition("Niemcy").category(countries).build();
        MemoCard ukraine = MemoCard.builder().name("Ukraine").definition("Ukraina").category(countries).build();
        MemoCard greatBritain = MemoCard.builder().name("Great Britain").definition("Wielka Brytania").category(countries).build();
        MemoCard unitedStates = MemoCard.builder().name("United States").definition("Stany Zjednoczone").category(countries).build();
        MemoCard armenia = MemoCard.builder().name("Armenia").definition("Armenia").category(countries).build();
        MemoCard switzerland = MemoCard.builder().name("Switzerland").definition("Szwajcaria").category(countries).build();
        MemoCard france = MemoCard.builder().name("France").definition("Francja").category(countries).build();
        MemoCard sweden = MemoCard.builder().name("Sweden").definition("Szwecja").category(countries).build();
        MemoCard austria = MemoCard.builder().name("Austria").definition("Austria").category(countries).build();
        MemoCard spain = MemoCard.builder().name("Spain").definition("Hiszpania").category(countries).build();
        MemoCard portugal = MemoCard.builder().name("Portugal").definition("Portugalia").category(countries).build();
        MemoCard indonesia = MemoCard.builder().name("Indonesia").definition("Indonezja").category(countries).build();
        MemoCard chile = MemoCard.builder().name("Chile").definition("Chile").category(countries).build();

        List<MemoCard> countriesMemoCards = Arrays.asList(poland, germany, ukraine, greatBritain, unitedStates, armenia, switzerland, france, sweden, austria, spain, portugal, indonesia, chile);
        memoCardRepository.saveAll(countriesMemoCards);
        countries.setMemoCardList(countriesMemoCards);
        categoryRepository.save(countries);

        // Furniture
        MemoCard table = MemoCard.builder().name("table").definition("stół").category(furniture).build();
        MemoCard chair = MemoCard.builder().name("chair").definition("krzesło").category(furniture).build();
        MemoCard shelf = MemoCard.builder().name("shelf").definition("półka").category(furniture).build();
        MemoCard bookcase = MemoCard.builder().name("bookcase").definition("regał").category(furniture).build();
        MemoCard bed = MemoCard.builder().name("bed").definition("łóżko").category(furniture).build();
        MemoCard lamp = MemoCard.builder().name("lamp").definition("lampa").category(furniture).build();
        MemoCard floor = MemoCard.builder().name("floor").definition("podłoga").category(furniture).build();
        MemoCard sofa = MemoCard.builder().name("sofa").definition("sofa").category(furniture).build();
        MemoCard closet = MemoCard.builder().name("closet").definition("szafa").category(furniture).build();
        MemoCard sink = MemoCard.builder().name("sink").definition("zlew").category(furniture).build();
        MemoCard door = MemoCard.builder().name("door").definition("drzwi").category(furniture).build();
        MemoCard desk = MemoCard.builder().name("desk").definition("biurko").category(furniture).build();

        List<MemoCard> furnitureMemoCard = Arrays.asList(chair, table, lamp, floor, sofa, closet, shelf, bookcase, sink, bed, door, desk);
        memoCardRepository.saveAll(furnitureMemoCard);
        furniture.setMemoCardList(furnitureMemoCard);
        categoryRepository.save(furniture);

        MemoCard dog = MemoCard.builder().name("dog").definition("pies").category(animals).build();
        MemoCard cat = MemoCard.builder().name("cat").definition("kot").category(animals).build();
        MemoCard mouse = MemoCard.builder().name("mouse").definition("mysz").category(animals).build();
        MemoCard pig = MemoCard.builder().name("pig").definition("świnia").category(animals).build();
        MemoCard deer = MemoCard.builder().name("deer").definition("jeleń").category(animals).build();
        MemoCard moose = MemoCard.builder().name("moose").definition("łoś").category(animals).build();
        MemoCard elephant = MemoCard.builder().name("elephant").definition("słoń").category(animals).build();
        MemoCard lion = MemoCard.builder().name("lion").definition("lew").category(animals).build();
        MemoCard sheep = MemoCard.builder().name("sheep").definition("owca").category(animals).build();
        MemoCard donkey = MemoCard.builder().name("donkey").definition("osioł").category(animals).build();
        MemoCard ant = MemoCard.builder().name("ant").definition("mrówka").category(animals).build();
        MemoCard snake = MemoCard.builder().name("snake").definition("wąż").category(animals).build();
        MemoCard bird = MemoCard.builder().name("bird").definition("ptak").category(animals).build();
        MemoCard spider = MemoCard.builder().name("spider").definition("pająk").category(animals).build();
        MemoCard beetle = MemoCard.builder().name("beetle").definition("chrząszcz").category(animals).build();
        MemoCard cow = MemoCard.builder().name("cow").definition("krowa").category(animals).build();
        MemoCard fish = MemoCard.builder().name("fish").definition("ryba").category(animals).build();
        MemoCard chicken = MemoCard.builder().name("chicken").definition("kurczak").category(animals).build();
        MemoCard turkey = MemoCard.builder().name("turkey").definition("indyk").category(animals).build();

        List<MemoCard> animalsMemoCards = Arrays.asList(dog, cat, mouse, pig, deer, moose, elephant, lion, sheep, donkey, ant, snake, bird, spider, beetle, cow, fish, chicken, turkey);
        memoCardRepository.saveAll(animalsMemoCards);
        animals.setMemoCardList(animalsMemoCards);
        categoryRepository.save(animals);

        // Family
        MemoCard father = MemoCard.builder().name("father").definition("ojciec").category(family).build();
        MemoCard mother = MemoCard.builder().name("mother").definition("matka").category(family).build();
        MemoCard son = MemoCard.builder().name("son").definition("syn").category(family).build();
        MemoCard daughter = MemoCard.builder().name("daughter").definition("córka").category(family).build();
        MemoCard aunt = MemoCard.builder().name("aunt").definition("ciocia").category(family).build();
        MemoCard uncle = MemoCard.builder().name("uncle").definition("wujek").category(family).build();
        MemoCard brother = MemoCard.builder().name("brother").definition("brat").category(family).build();
        MemoCard sister = MemoCard.builder().name("sister").definition("siostra").category(family).build();
        MemoCard grandma = MemoCard.builder().name("grandma").definition("babcia").category(family).build();
        MemoCard grandpa = MemoCard.builder().name("grandpa").definition("dziadek").category(family).build();
        MemoCard cousin = MemoCard.builder().name("cousin").definition("kuzyn(ka)").category(family).build();
        MemoCard child = MemoCard.builder().name("child").definition("dziecko").category(family).build();
        MemoCard teen = MemoCard.builder().name("teen").definition("nastolatek").category(family).build();
        MemoCard parents = MemoCard.builder().name("parents").definition("rodzice").category(family).build();

        List<MemoCard> familyMemoCards = Arrays.asList(father, mother, son, daughter, aunt, uncle, brother, sister, grandma, grandpa, cousin, child, teen, parents);
        memoCardRepository.saveAll(familyMemoCards);
        family.setMemoCardList(familyMemoCards);
        categoryRepository.save(family);

        // Buildings
        MemoCard postOffice = MemoCard.builder().name("post office").definition("poczta").category(buildings).build();
        MemoCard policeStation = MemoCard.builder().name("police station").definition("posterunek policji").category(buildings).build();
        MemoCard school = MemoCard.builder().name("school").definition("szkoła").category(buildings).build();
        MemoCard university = MemoCard.builder().name("university").definition("uniwersytet").category(buildings).build();
        MemoCard prison = MemoCard.builder().name("prison").definition("więzienie").category(buildings).build();
        MemoCard hospital = MemoCard.builder().name("hospital").definition("szpital").category(buildings).build();
        MemoCard office = MemoCard.builder().name("office").definition("biuro").category(buildings).build();
        MemoCard townHall = MemoCard.builder().name("town hall").definition("ratusz").category(buildings).build();
        MemoCard stadium = MemoCard.builder().name("stadium").definition("stadion").category(buildings).build();
        MemoCard hotel = MemoCard.builder().name("hotel").definition("hotel").category(buildings).build();
        MemoCard museum = MemoCard.builder().name("museum").definition("muzeum").category(buildings).build();
        MemoCard artGallery = MemoCard.builder().name("art gallery").definition("galeria sztuki").category(buildings).build();
        MemoCard railwayStation = MemoCard.builder().name("railway station").definition("dworzec kolejowy").category(buildings).build();

        List<MemoCard> buildingsMemoCards = Arrays.asList(postOffice, policeStation, school, university, prison, hospital, office, townHall, stadium, hotel, museum, artGallery, railwayStation);
        memoCardRepository.saveAll(buildingsMemoCards);
        buildings.setMemoCardList(buildingsMemoCards);
        categoryRepository.save(buildings);

        // Weather
        MemoCard rain = MemoCard.builder().name("rain").definition("deszcz").category(weather).build();
        MemoCard sun = MemoCard.builder().name("sun").definition("słońce").category(weather).build();
        MemoCard snow = MemoCard.builder().name("snow").definition("śnieg").category(weather).build();
        MemoCard fog = MemoCard.builder().name("fog").definition("mgła").category(weather).build();
        MemoCard smog = MemoCard.builder().name("smog").definition("smog").category(weather).build();
        MemoCard cold = MemoCard.builder().name("cold").definition("zimno").category(weather).build();
        MemoCard warm = MemoCard.builder().name("warm").definition("ciepło").category(weather).build();
        MemoCard hot = MemoCard.builder().name("hot").definition("gorąco").category(weather).build();
        MemoCard ice = MemoCard.builder().name("ice").definition("lód").category(weather).build();
        MemoCard cloud = MemoCard.builder().name("cloud").definition("chmura").category(weather).build();
        MemoCard day = MemoCard.builder().name("day").definition("dzień").category(weather).build();
        MemoCard night = MemoCard.builder().name("night").definition("noc").category(weather).build();
        MemoCard flood = MemoCard.builder().name("flood").definition("powódź").category(weather).build();
        MemoCard wet = MemoCard.builder().name("wet").definition("mokro").category(weather).build();
        MemoCard dry = MemoCard.builder().name("dry").definition("sucho").category(weather).build();
        MemoCard gloomy = MemoCard.builder().name("gloomy").definition("ponuro").category(weather).build();
        MemoCard storm = MemoCard.builder().name("storm").definition("burza").category(weather).build();
        MemoCard lightning = MemoCard.builder().name("lightning").definition("błyskawica").category(weather).build();

        List<MemoCard> weatherMemoCards = Arrays.asList(rain, sun, snow, fog, smog, cold, warm, hot, ice, cloud, day, night, flood, wet, dry, gloomy, storm, lightning);
        memoCardRepository.saveAll(weatherMemoCards);
        weather.setMemoCardList(weatherMemoCards);
        categoryRepository.save(weather);

        // Cities
        MemoCard warsaw = MemoCard.builder().name("Warsaw").definition("Warszawa").category(cities).build();
        MemoCard paris = MemoCard.builder().name("Paris").definition("Paryż").category(cities).build();
        MemoCard moscow = MemoCard.builder().name("Moscow").definition("Moskwa").category(cities).build();
        MemoCard prague = MemoCard.builder().name("Prague").definition("Praga").category(cities).build();
        MemoCard stockholm = MemoCard.builder().name("Stockholm").definition("Sztokholm").category(cities).build();
        MemoCard city = MemoCard.builder().name("city").definition("miasto").category(cities).build();
        MemoCard capital = MemoCard.builder().name("capital").definition("stolica").category(cities).build();
        MemoCard madrid = MemoCard.builder().name("Madrid").definition("Madryd").category(cities).build();
        MemoCard london = MemoCard.builder().name("London").definition("Londyn").category(cities).build();
        MemoCard newYork = MemoCard.builder().name("New York").definition("Nowy Jork").category(cities).build();
        MemoCard cracow = MemoCard.builder().name("Cracow").definition("Kraków").category(cities).build();

        List<MemoCard> citiesMemoCards = Arrays.asList(warsaw, paris, moscow, prague, stockholm, city, capital, madrid, london, newYork, cracow);
        memoCardRepository.saveAll(citiesMemoCards);
        cities.setMemoCardList(citiesMemoCards);
        categoryRepository.save(cities);

        // Food
        MemoCard soup = MemoCard.builder().name("soup").definition("zupa").category(food).build();
        MemoCard chocolate = MemoCard.builder().name("chocolate").definition("czekolada").category(food).build();
        MemoCard beef = MemoCard.builder().name("beef").definition("wołowina").category(food).build();
        MemoCard fries = MemoCard.builder().name("fries").definition("frytki").category(food).build();
        MemoCard potato = MemoCard.builder().name("potato").definition("ziemniak").category(food).build();
        MemoCard ham = MemoCard.builder().name("ham").definition("szynka").category(food).build();
        MemoCard bread = MemoCard.builder().name("bread").definition("chleb").category(food).build();
        MemoCard cereal = MemoCard.builder().name("cereal").definition("płatki śniadaniowe").category(food).build();
        MemoCard rice = MemoCard.builder().name("rice").definition("ryż").category(food).build();
        MemoCard toast = MemoCard.builder().name("toast").definition("tost").category(food).build();
        MemoCard chocolateBar = MemoCard.builder().name("chocolate bar").definition("baton czekoladowy").category(food).build();
        MemoCard bowl = MemoCard.builder().name("bowl").definition("miska").category(food).build();
        MemoCard plate = MemoCard.builder().name("plate").definition("talerz").category(food).build();
        MemoCard knife = MemoCard.builder().name("knife").definition("nóż").category(food).build();
        MemoCard fork = MemoCard.builder().name("fork").definition("widelec").category(food).build();
        MemoCard spoon = MemoCard.builder().name("spoon").definition("łyżka").category(food).build();

        List<MemoCard> foodMemoCards = Arrays.asList(soup, chocolate, beef, fries, potato, ham, bread, cereal, rice, toast, chocolateBar, bowl, plate, knife, fork, spoon);
        memoCardRepository.saveAll(foodMemoCards);
        food.setMemoCardList(foodMemoCards);
        categoryRepository.save(food);

        // Vehicles
        MemoCard car = MemoCard.builder().name("car").definition("samochód").category(vehicles).build();
        MemoCard airplane = MemoCard.builder().name("airplane").definition("samolot").category(vehicles).build();
        MemoCard train = MemoCard.builder().name("train").definition("pociąg").category(vehicles).build();
        MemoCard tram = MemoCard.builder().name("tram").definition("tramwaj").category(vehicles).build();
        MemoCard bus = MemoCard.builder().name("bus").definition("autobus").category(vehicles).build();
        MemoCard bike = MemoCard.builder().name("bike").definition("rower").category(vehicles).build();
        MemoCard scooter = MemoCard.builder().name("scooter").definition("skuter").category(vehicles).build();
        MemoCard truck = MemoCard.builder().name("truck").definition("ciężarówka").category(vehicles).build();
        MemoCard boat = MemoCard.builder().name("boat").definition("łódka").category(vehicles).build();
        MemoCard ship = MemoCard.builder().name("ship").definition("statek").category(vehicles).build();
        MemoCard ferry = MemoCard.builder().name("ferry").definition("prom").category(vehicles).build();
        MemoCard helicopter = MemoCard.builder().name("helicopter").definition("helikopter").category(vehicles).build();
        MemoCard spacecraft = MemoCard.builder().name("spacecraft").definition("statek kosmiczny").category(vehicles).build();
        MemoCard hovercraft = MemoCard.builder().name("hovercraft").definition("poduszkowiec").category(vehicles).build();

        List<MemoCard> vehiclesMemoCards = Arrays.asList(car, airplane, train, tram, bus, bike, scooter, truck, boat, ship, ferry, helicopter, spacecraft, hovercraft);
        memoCardRepository.saveAll(vehiclesMemoCards);
        vehicles.setMemoCardList(vehiclesMemoCards);
        categoryRepository.save(vehicles);

        // Items
        MemoCard phone = MemoCard.builder().name("phone").definition("telefon").category(items).build();
        MemoCard computer = MemoCard.builder().name("computer").definition("komputer").category(items).build();
        MemoCard speaker = MemoCard.builder().name("speaker").definition("głośnik").category(items).build();
        MemoCard keyboard = MemoCard.builder().name("keyboard").definition("klawiatura").category(items).build();
        MemoCard computerMouse = MemoCard.builder().name("computer mouse").definition("mysz komputerowa").category(items).build();
        MemoCard microphone = MemoCard.builder().name("microphone").definition("mikrofon").category(items).build();
        MemoCard cable = MemoCard.builder().name("cable").definition("kabel").category(items).build();
        MemoCard headphones = MemoCard.builder().name("headphones").definition("słuchawki").category(items).build();
        MemoCard card = MemoCard.builder().name("card").definition("karta").category(items).build();
        MemoCard key = MemoCard.builder().name("key").definition("klucz").category(items).build();
        MemoCard camera = MemoCard.builder().name("camera").definition("kamera").category(items).build();
        MemoCard screen = MemoCard.builder().name("screen").definition("ekran").category(items).build();
        MemoCard guitar = MemoCard.builder().name("guitar").definition("gitara").category(items).build();
        MemoCard stick = MemoCard.builder().name("stick").definition("patyk").category(items).build();
        MemoCard spray = MemoCard.builder().name("spray").definition("sprej").category(items).build();
        MemoCard charger = MemoCard.builder().name("charger").definition("ładowarka").category(items).build();
        MemoCard notebook = MemoCard.builder().name("notebook").definition("zeszyt").category(items).build();
        MemoCard book = MemoCard.builder().name("book").definition("książka").category(items).build();

        List<MemoCard> itemsMemoCards = Arrays.asList(phone, computer, speaker, keyboard, computerMouse, microphone, cable, headphones, card, key, camera, screen, guitar, stick, spray, charger, notebook, book);
        memoCardRepository.saveAll(itemsMemoCards);
        items.setMemoCardList(itemsMemoCards);
        categoryRepository.save(items);

        // Work


        // Drinks

    }

    private Byte[] getBytes(String path) throws IOException {
        BufferedImage bImage = ImageIO.read(new File(path));
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(bImage, "jpg", bos );
        byte [] data = bos.toByteArray();
        Byte[] bytes = new Byte[data.length];
        Arrays.setAll(bytes, n -> data[n]);
        return bytes;
    }
}