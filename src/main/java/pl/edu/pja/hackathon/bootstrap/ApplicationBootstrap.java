package pl.edu.pja.hackathon.bootstrap;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pl.edu.pja.hackathon.model.Category;
import pl.edu.pja.hackathon.model.User;
import pl.edu.pja.hackathon.model.memocard.DifficultyEnum;
import pl.edu.pja.hackathon.model.memocard.MemoCard;
import pl.edu.pja.hackathon.repositories.CategoryRepository;
import pl.edu.pja.hackathon.repositories.MemoCardRepository;
import pl.edu.pja.hackathon.repositories.UserRepository;

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
    private final UserRepository userRepository;

    @Override
    @SneakyThrows
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        Byte[] horrorImage = getBytes("src/main/resources/static/pictures/kiwi_oil.jpg");
        Byte[] colorsImage = getBytes("src/main/resources/static/pictures/colors.jpg");
        Byte[] furnitureImage = getBytes("src/main/resources/static/pictures/furniture.jpg");
        Byte[] animalsImage = getBytes("src/main/resources/static/pictures/animals.jpg");
        Byte[] familyImage = getBytes("src/main/resources/static/pictures/family.jpg");
        Byte[] foodImage = getBytes("src/main/resources/static/pictures/food.jpg");
        Byte[] vehicleImage = getBytes("src/main/resources/static/pictures/vehicle.jpg");
        Byte[] itemsImage = getBytes("src/main/resources/static/pictures/items.jpg");
        Byte[] citiesImage = getBytes("src/main/resources/static/pictures/cities.jpg");
        Byte[] weatherImage = getBytes("src/main/resources/static/pictures/weather.jpg");
        Byte[] workImage = getBytes("src/main/resources/static/pictures/work.jpg");
        Byte[] drinksImage = getBytes("src/main/resources/static/pictures/drinks.jpg");
        Byte[] countriesImage = getBytes("src/main/resources/static/pictures/countries.jpg");
        Byte[] buildingsImage = getBytes("src/main/resources/static/pictures/buildings.jpg");

        // Categories
        Category colors = Category.builder().name("Kolory").image(colorsImage).build();
        Category countries = Category.builder().name("Państwa").image(countriesImage).build();
        Category furniture = Category.builder().name("Meble").image(furnitureImage).build();
        Category animals = Category.builder().name("Zwierzęta").image(animalsImage).build();
        Category family = Category.builder().name("Rodzina").image(familyImage).build();
        Category buildings = Category.builder().name("Budynki").image(buildingsImage).build();
        Category food = Category.builder().name("Jedzenie").image(foodImage).build();
        Category vehicles = Category.builder().name("Pojazdy").image(vehicleImage).build();
        Category items = Category.builder().name("Przedmioty").image(itemsImage).build();
        Category cities = Category.builder().name("Miasta").image(citiesImage).build();
        Category weather = Category.builder().name("Pogoda").image(weatherImage).build();
        Category work = Category.builder().name("Praca").image(workImage).build();
        Category drinks = Category.builder().name("Napoje").image(drinksImage).build();

        categoryRepository.saveAll(Arrays.asList(colors, countries, furniture, animals, family, buildings, food, vehicles, items, cities, weather, work, drinks));

        // Colors
        MemoCard black = MemoCard.builder().name("black").definition("czarny").category(colors).difficultyEnum(DifficultyEnum.EASY).build();
        MemoCard white = MemoCard.builder().name("white").definition("biały").category(colors).difficultyEnum(DifficultyEnum.EASY).build();
        MemoCard orange = MemoCard.builder().name("orange").definition("pomarańczowy").category(colors).difficultyEnum(DifficultyEnum.MEDIUM).build();
        MemoCard red = MemoCard.builder().name("red").definition("czerwony").category(colors).difficultyEnum(DifficultyEnum.MEDIUM).build();
        MemoCard blue = MemoCard.builder().name("blue").definition("niebieski").category(colors).difficultyEnum(DifficultyEnum.MEDIUM).build();
        MemoCard grey = MemoCard.builder().name("grey").definition("szary").category(colors).difficultyEnum(DifficultyEnum.MEDIUM).build();
        MemoCard pink = MemoCard.builder().name("pink").definition("różowy").category(colors).difficultyEnum(DifficultyEnum.HARD).build();
        MemoCard brown = MemoCard.builder().name("brown").definition("brązowy").category(colors).difficultyEnum(DifficultyEnum.MEDIUM).build();
        MemoCard yellow = MemoCard.builder().name("yellow").definition("żółty").category(colors).difficultyEnum(DifficultyEnum.HARD).build();

        List<MemoCard> colorMemoCards = Arrays.asList(black, white, orange, red, blue, grey, pink, brown, yellow);
        memoCardRepository.saveAll(colorMemoCards);
        colors.setMemoCardList(colorMemoCards);
        categoryRepository.save(colors);

        // Countries
        MemoCard poland = MemoCard.builder().name("Poland").definition("Polska").difficultyEnum(DifficultyEnum.EASY).category(countries).build();
        MemoCard germany = MemoCard.builder().name("Germany").definition("Niemcy").difficultyEnum(DifficultyEnum.MEDIUM).category(countries).build();
        MemoCard ukraine = MemoCard.builder().name("Ukraine").definition("Ukraina").difficultyEnum(DifficultyEnum.EASY).category(countries).build();
        MemoCard greatBritain = MemoCard.builder().name("Great Britain").definition("Wielka Brytania").difficultyEnum(DifficultyEnum.HARD).category(countries).build();
        MemoCard unitedStates = MemoCard.builder().name("United States").definition("Stany Zjednoczone").difficultyEnum(DifficultyEnum.HARD).category(countries).build();
        MemoCard switzerland = MemoCard.builder().name("Switzerland").definition("Szwajcaria").difficultyEnum(DifficultyEnum.MEDIUM).category(countries).build();
        MemoCard france = MemoCard.builder().name("France").definition("Francja").difficultyEnum(DifficultyEnum.EASY).category(countries).build();
        MemoCard sweden = MemoCard.builder().name("Sweden").definition("Szwecja").difficultyEnum(DifficultyEnum.EASY).category(countries).build();
        MemoCard spain = MemoCard.builder().name("Spain").definition("Hiszpania").difficultyEnum(DifficultyEnum.MEDIUM).category(countries).build();
        MemoCard portugal = MemoCard.builder().name("Portugal").definition("Portugalia").difficultyEnum(DifficultyEnum.EASY).category(countries).build();
        MemoCard indonesia = MemoCard.builder().name("Indonesia").definition("Indonezja").difficultyEnum(DifficultyEnum.EASY).category(countries).build();
        MemoCard canada = MemoCard.builder().name("Canada").definition("Kanada").difficultyEnum(DifficultyEnum.EASY).category(countries).build();

        List<MemoCard> countriesMemoCards = Arrays.asList(poland, germany, ukraine, greatBritain, unitedStates, switzerland, france, sweden, spain, portugal, indonesia, canada);
        memoCardRepository.saveAll(countriesMemoCards);
        countries.setMemoCardList(countriesMemoCards);
        categoryRepository.save(countries);

        // Furniture
        MemoCard table = MemoCard.builder().name("table").definition("stół").category(furniture).difficultyEnum(DifficultyEnum.HARD).build();
        MemoCard chair = MemoCard.builder().name("chair").definition("krzesło").category(furniture).difficultyEnum(DifficultyEnum.MEDIUM).build();
        MemoCard shelf = MemoCard.builder().name("shelf").definition("półka").category(furniture).difficultyEnum(DifficultyEnum.MEDIUM).build();
        MemoCard bookcase = MemoCard.builder().name("bookcase").definition("regał").category(furniture).difficultyEnum(DifficultyEnum.MEDIUM).build();
        MemoCard bed = MemoCard.builder().name("bed").definition("łóżko").category(furniture).difficultyEnum(DifficultyEnum.HARD).build();
        MemoCard lamp = MemoCard.builder().name("lamp").definition("lampa").category(furniture).difficultyEnum(DifficultyEnum.EASY).build();
        MemoCard floor = MemoCard.builder().name("floor").definition("podłoga").category(furniture).difficultyEnum(DifficultyEnum.MEDIUM).build();
        MemoCard closet = MemoCard.builder().name("closet").definition("szafa").category(furniture).difficultyEnum(DifficultyEnum.MEDIUM).build();
        MemoCard sink = MemoCard.builder().name("sink").definition("zlew").category(furniture).difficultyEnum(DifficultyEnum.MEDIUM).build();
        MemoCard door = MemoCard.builder().name("door").definition("drzwi").category(furniture).difficultyEnum(DifficultyEnum.MEDIUM).build();
        MemoCard desk = MemoCard.builder().name("desk").definition("biurko").category(furniture).difficultyEnum(DifficultyEnum.MEDIUM).build();

        List<MemoCard> furnitureMemoCard = Arrays.asList(chair, table, lamp, floor, closet, shelf, bookcase, sink, bed, door, desk);
        memoCardRepository.saveAll(furnitureMemoCard);
        furniture.setMemoCardList(furnitureMemoCard);
        categoryRepository.save(furniture);

        MemoCard dog = MemoCard.builder().name("dog").definition("pies").category(animals).difficultyEnum(DifficultyEnum.EASY).build();
        MemoCard cat = MemoCard.builder().name("cat").definition("kot").category(animals).difficultyEnum(DifficultyEnum.EASY).build();
        MemoCard mouse = MemoCard.builder().name("mouse").definition("mysz").category(animals).difficultyEnum(DifficultyEnum.EASY).build();
        MemoCard pig = MemoCard.builder().name("pig").definition("świnia").category(animals).difficultyEnum(DifficultyEnum.MEDIUM).build();
        MemoCard deer = MemoCard.builder().name("deer").definition("jeleń").category(animals).difficultyEnum(DifficultyEnum.MEDIUM).build();
        MemoCard moose = MemoCard.builder().name("moose").definition("łoś").category(animals).difficultyEnum(DifficultyEnum.MEDIUM).build();
        MemoCard elephant = MemoCard.builder().name("elephant").definition("słoń").category(animals).difficultyEnum(DifficultyEnum.MEDIUM).build();
        MemoCard lion = MemoCard.builder().name("lion").definition("lew").category(animals).difficultyEnum(DifficultyEnum.EASY).build();
        MemoCard sheep = MemoCard.builder().name("sheep").definition("owca").category(animals).difficultyEnum(DifficultyEnum.EASY).build();
        MemoCard donkey = MemoCard.builder().name("donkey").definition("osioł").category(animals).difficultyEnum(DifficultyEnum.MEDIUM).build();
        MemoCard ant = MemoCard.builder().name("ant").definition("mrówka").category(animals).difficultyEnum(DifficultyEnum.MEDIUM).build();
        MemoCard snake = MemoCard.builder().name("snake").definition("wąż").category(animals).difficultyEnum(DifficultyEnum.EASY).build();
        MemoCard bird = MemoCard.builder().name("bird").definition("ptak").category(animals).difficultyEnum(DifficultyEnum.EASY).build();
        MemoCard spider = MemoCard.builder().name("spider").definition("pająk").category(animals).difficultyEnum(DifficultyEnum.MEDIUM).build();
        MemoCard beetle = MemoCard.builder().name("beetle").definition("chrząszcz").category(animals).difficultyEnum(DifficultyEnum.HARD).build();
        MemoCard cow = MemoCard.builder().name("cow").definition("krowa").category(animals).difficultyEnum(DifficultyEnum.MEDIUM).build();
        MemoCard fish = MemoCard.builder().name("fish").definition("ryba").category(animals).difficultyEnum(DifficultyEnum.EASY).build();
        MemoCard chicken = MemoCard.builder().name("chicken").definition("kurczak").category(animals).difficultyEnum(DifficultyEnum.MEDIUM).build();
        MemoCard turkey = MemoCard.builder().name("turkey").definition("indyk").category(animals).difficultyEnum(DifficultyEnum.MEDIUM).build();

        List<MemoCard> animalsMemoCards = Arrays.asList(dog, cat, mouse, pig, deer, moose, elephant, lion, sheep, donkey, ant, snake, bird, spider, beetle, cow, fish, chicken, turkey);
        memoCardRepository.saveAll(animalsMemoCards);
        animals.setMemoCardList(animalsMemoCards);
        categoryRepository.save(animals);

        // Family
        MemoCard father = MemoCard.builder().name("father").definition("ojciec").category(family).difficultyEnum(DifficultyEnum.MEDIUM).build();
        MemoCard mother = MemoCard.builder().name("mother").definition("matka").category(family).difficultyEnum(DifficultyEnum.EASY).build();
        MemoCard son = MemoCard.builder().name("son").definition("syn").category(family).difficultyEnum(DifficultyEnum.EASY).build();
        MemoCard daughter = MemoCard.builder().name("daughter").definition("córka").category(family).difficultyEnum(DifficultyEnum.MEDIUM).build();
        MemoCard aunt = MemoCard.builder().name("aunt").definition("ciocia").category(family).difficultyEnum(DifficultyEnum.MEDIUM).build();
        MemoCard uncle = MemoCard.builder().name("uncle").definition("wujek").category(family).difficultyEnum(DifficultyEnum.MEDIUM).build();
        MemoCard brother = MemoCard.builder().name("brother").definition("brat").category(family).difficultyEnum(DifficultyEnum.EASY).build();
        MemoCard sister = MemoCard.builder().name("sister").definition("siostra").category(family).difficultyEnum(DifficultyEnum.EASY).build();
        MemoCard grandma = MemoCard.builder().name("grandma").definition("babcia").category(family).difficultyEnum(DifficultyEnum.MEDIUM).build();
        MemoCard grandpa = MemoCard.builder().name("grandpa").definition("dziadek").category(family).difficultyEnum(DifficultyEnum.MEDIUM).build();
        MemoCard cousin = MemoCard.builder().name("cousin").definition("kuzyn(ka)").category(family).difficultyEnum(DifficultyEnum.HARD).build();
        MemoCard child = MemoCard.builder().name("child").definition("dziecko").category(family).difficultyEnum(DifficultyEnum.MEDIUM).build();
        MemoCard teen = MemoCard.builder().name("teen").definition("nastolatek").category(family).difficultyEnum(DifficultyEnum.MEDIUM).build();
        MemoCard parents = MemoCard.builder().name("parents").definition("rodzice").category(family).difficultyEnum(DifficultyEnum.MEDIUM).build();

        List<MemoCard> familyMemoCards = Arrays.asList(father, mother, son, daughter, aunt, uncle, brother, sister, grandma, grandpa, cousin, child, teen, parents);
        memoCardRepository.saveAll(familyMemoCards);
        family.setMemoCardList(familyMemoCards);
        categoryRepository.save(family);

        // Buildings
        MemoCard postOffice = MemoCard.builder().name("post office").definition("poczta").category(buildings).difficultyEnum(DifficultyEnum.MEDIUM).build();
        MemoCard policeStation = MemoCard.builder().name("police station").definition("posterunek policji").difficultyEnum(DifficultyEnum.VERY_HARD).category(buildings).build();
        MemoCard school = MemoCard.builder().name("school").definition("szkoła").category(buildings).difficultyEnum(DifficultyEnum.MEDIUM).build();
        MemoCard university = MemoCard.builder().name("university").definition("uniwersytet").category(buildings).difficultyEnum(DifficultyEnum.EASY).build();
        MemoCard prison = MemoCard.builder().name("prison").definition("więzienie").category(buildings).difficultyEnum(DifficultyEnum.MEDIUM).build();
        MemoCard hospital = MemoCard.builder().name("hospital").definition("szpital").category(buildings).difficultyEnum(DifficultyEnum.MEDIUM).build();
        MemoCard office = MemoCard.builder().name("office").definition("biuro").category(buildings).difficultyEnum(DifficultyEnum.EASY).build();
        MemoCard townHall = MemoCard.builder().name("town hall").definition("ratusz").category(buildings).difficultyEnum(DifficultyEnum.MEDIUM).build();
        MemoCard stadium = MemoCard.builder().name("stadium").definition("stadion").category(buildings).difficultyEnum(DifficultyEnum.EASY).build();
        MemoCard museum = MemoCard.builder().name("museum").definition("muzeum").category(buildings).difficultyEnum(DifficultyEnum.EASY).build();
        MemoCard artGallery = MemoCard.builder().name("art gallery").definition("galeria sztuki").category(buildings).difficultyEnum(DifficultyEnum.VERY_HARD).build();
        MemoCard railwayStation = MemoCard.builder().name("railway station").definition("dworzec kolejowy").category(buildings).difficultyEnum(DifficultyEnum.VERY_HARD).build();

        List<MemoCard> buildingsMemoCards = Arrays.asList(postOffice, policeStation, school, university, prison, hospital, office, townHall, stadium, museum, artGallery, railwayStation);
        memoCardRepository.saveAll(buildingsMemoCards);
        buildings.setMemoCardList(buildingsMemoCards);
        categoryRepository.save(buildings);

        // Weather
        MemoCard rain = MemoCard.builder().name("rain").definition("deszcz").category(weather).difficultyEnum(DifficultyEnum.MEDIUM).build();
        MemoCard sun = MemoCard.builder().name("sun").definition("słońce").category(weather).difficultyEnum(DifficultyEnum.MEDIUM).build();
        MemoCard snow = MemoCard.builder().name("snow").definition("śnieg").category(weather).difficultyEnum(DifficultyEnum.MEDIUM).build();
        MemoCard fog = MemoCard.builder().name("fog").definition("mgła").category(weather).difficultyEnum(DifficultyEnum.MEDIUM).build();
        MemoCard cold = MemoCard.builder().name("cold").definition("zimno").category(weather).difficultyEnum(DifficultyEnum.MEDIUM).build();
        MemoCard warm = MemoCard.builder().name("warm").definition("ciepło").category(weather).difficultyEnum(DifficultyEnum.MEDIUM).build();
        MemoCard hot = MemoCard.builder().name("hot").definition("gorąco").category(weather).difficultyEnum(DifficultyEnum.MEDIUM).build();
        MemoCard ice = MemoCard.builder().name("ice").definition("lód").category(weather).difficultyEnum(DifficultyEnum.EASY).build();
        MemoCard cloud = MemoCard.builder().name("cloud").definition("chmura").category(weather).difficultyEnum(DifficultyEnum.MEDIUM).build();
        MemoCard day = MemoCard.builder().name("day").definition("dzień").category(weather).difficultyEnum(DifficultyEnum.EASY).build();
        MemoCard night = MemoCard.builder().name("night").definition("noc").category(weather).difficultyEnum(DifficultyEnum.EASY).build();
        MemoCard flood = MemoCard.builder().name("flood").definition("powódź").category(weather).difficultyEnum(DifficultyEnum.MEDIUM).build();
        MemoCard wet = MemoCard.builder().name("wet").definition("mokro").category(weather).difficultyEnum(DifficultyEnum.MEDIUM).build();
        MemoCard dry = MemoCard.builder().name("dry").definition("sucho").category(weather).difficultyEnum(DifficultyEnum.MEDIUM).build();
        MemoCard storm = MemoCard.builder().name("storm").definition("burza").category(weather).difficultyEnum(DifficultyEnum.MEDIUM).build();
        MemoCard lightning = MemoCard.builder().name("lightning").definition("błyskawica").category(weather).difficultyEnum(DifficultyEnum.HARD).build();

        List<MemoCard> weatherMemoCards = Arrays.asList(rain, sun, snow, fog, cold, warm, hot, ice, cloud, day, night, flood, wet, dry, storm, lightning);
        memoCardRepository.saveAll(weatherMemoCards);
        weather.setMemoCardList(weatherMemoCards);
        categoryRepository.save(weather);

        // Cities
        MemoCard warsaw = MemoCard.builder().name("Warsaw").definition("Warszawa").category(cities).difficultyEnum(DifficultyEnum.EASY).build();
        MemoCard paris = MemoCard.builder().name("Paris").definition("Paryż").category(cities).difficultyEnum(DifficultyEnum.EASY).build();
        MemoCard moscow = MemoCard.builder().name("Moscow").definition("Moskwa").category(cities).difficultyEnum(DifficultyEnum.EASY).build();
        MemoCard prague = MemoCard.builder().name("Prague").definition("Praga").category(cities).difficultyEnum(DifficultyEnum.EASY).build();
        MemoCard stockholm = MemoCard.builder().name("Stockholm").definition("Sztokholm").category(cities).difficultyEnum(DifficultyEnum.EASY).build();
        MemoCard city = MemoCard.builder().name("city").definition("miasto").category(cities).difficultyEnum(DifficultyEnum.MEDIUM).build();
        MemoCard capital = MemoCard.builder().name("capital").definition("stolica").category(cities).difficultyEnum(DifficultyEnum.MEDIUM).build();
        MemoCard madrid = MemoCard.builder().name("Madrid").definition("Madryd").category(cities).difficultyEnum(DifficultyEnum.EASY).build();
        MemoCard london = MemoCard.builder().name("London").definition("Londyn").category(cities).difficultyEnum(DifficultyEnum.EASY).build();
        MemoCard newYork = MemoCard.builder().name("New York").definition("Nowy Jork").category(cities).difficultyEnum(DifficultyEnum.MEDIUM).build();
        MemoCard cracow = MemoCard.builder().name("Cracow").definition("Kraków").category(cities).difficultyEnum(DifficultyEnum.MEDIUM).build();

        List<MemoCard> citiesMemoCards = Arrays.asList(warsaw, paris, moscow, prague, stockholm, city, capital, madrid, london, newYork, cracow);
        memoCardRepository.saveAll(citiesMemoCards);
        cities.setMemoCardList(citiesMemoCards);
        categoryRepository.save(cities);

        // Food
        MemoCard soup = MemoCard.builder().name("soup").definition("zupa").category(food).difficultyEnum(DifficultyEnum.EASY).build();
        MemoCard chocolate = MemoCard.builder().name("chocolate").definition("czekolada").difficultyEnum(DifficultyEnum.MEDIUM).category(food).build();
        MemoCard beef = MemoCard.builder().name("beef").definition("wołowina").difficultyEnum(DifficultyEnum.MEDIUM).category(food).build();
        MemoCard fries = MemoCard.builder().name("fries").definition("frytki").category(food).difficultyEnum(DifficultyEnum.EASY).build();
        MemoCard potato = MemoCard.builder().name("potato").definition("ziemniak").category(food).difficultyEnum(DifficultyEnum.MEDIUM).build();
        MemoCard ham = MemoCard.builder().name("ham").definition("szynka").category(food).difficultyEnum(DifficultyEnum.MEDIUM).build();
        MemoCard bread = MemoCard.builder().name("bread").definition("chleb").category(food).difficultyEnum(DifficultyEnum.EASY).build();
        MemoCard cereal = MemoCard.builder().name("cereal").definition("płatki śniadaniowe").category(food).difficultyEnum(DifficultyEnum.VERY_HARD).build();
        MemoCard rice = MemoCard.builder().name("rice").definition("ryż").category(food).difficultyEnum(DifficultyEnum.EASY).build();
        MemoCard toast = MemoCard.builder().name("toast").definition("tost").category(food).difficultyEnum(DifficultyEnum.EASY).build();
        MemoCard chocolateBar = MemoCard.builder().name("chocolate bar").definition("baton czekoladowy").difficultyEnum(DifficultyEnum.VERY_HARD).category(food).build();
        MemoCard bowl = MemoCard.builder().name("bowl").definition("miska").category(food).difficultyEnum(DifficultyEnum.EASY).build();
        MemoCard plate = MemoCard.builder().name("plate").definition("talerz").category(food).difficultyEnum(DifficultyEnum.MEDIUM).build();
        MemoCard knife = MemoCard.builder().name("knife").definition("nóż").category(food).difficultyEnum(DifficultyEnum.EASY).build();
        MemoCard fork = MemoCard.builder().name("fork").definition("widelec").category(food).difficultyEnum(DifficultyEnum.MEDIUM).build();
        MemoCard spoon = MemoCard.builder().name("spoon").definition("łyżka").category(food).difficultyEnum(DifficultyEnum.MEDIUM).build();

        List<MemoCard> foodMemoCards = Arrays.asList(soup, chocolate, beef, fries, potato, ham, bread, cereal, rice, toast, chocolateBar, bowl, plate, knife, fork, spoon);
        memoCardRepository.saveAll(foodMemoCards);
        food.setMemoCardList(foodMemoCards);
        categoryRepository.save(food);

        // Vehicles
        MemoCard car = MemoCard.builder().name("car").definition("samochód").category(vehicles).difficultyEnum(DifficultyEnum.MEDIUM).build();
        MemoCard airplane = MemoCard.builder().name("airplane").definition("samolot").category(vehicles).difficultyEnum(DifficultyEnum.MEDIUM).build();
        MemoCard train = MemoCard.builder().name("train").definition("pociąg").category(vehicles).difficultyEnum(DifficultyEnum.MEDIUM).build();
        MemoCard tram = MemoCard.builder().name("tram").definition("tramwaj").category(vehicles).difficultyEnum(DifficultyEnum.EASY).build();
        MemoCard bus = MemoCard.builder().name("bus").definition("autobus").category(vehicles).difficultyEnum(DifficultyEnum.EASY).build();
        MemoCard bike = MemoCard.builder().name("bike").definition("rower").category(vehicles).difficultyEnum(DifficultyEnum.EASY).build();
        MemoCard scooter = MemoCard.builder().name("scooter").definition("skuter").category(vehicles).difficultyEnum(DifficultyEnum.EASY).build();
        MemoCard truck = MemoCard.builder().name("truck").definition("ciężarówka").category(vehicles).difficultyEnum(DifficultyEnum.HARD).build();
        MemoCard boat = MemoCard.builder().name("boat").definition("łódka").category(vehicles).difficultyEnum(DifficultyEnum.MEDIUM).build();
        MemoCard ship = MemoCard.builder().name("ship").definition("statek").category(vehicles).difficultyEnum(DifficultyEnum.EASY).build();
        MemoCard ferry = MemoCard.builder().name("ferry").definition("prom").category(vehicles).difficultyEnum(DifficultyEnum.EASY).build();
        MemoCard helicopter = MemoCard.builder().name("helicopter").definition("helikopter").category(vehicles).difficultyEnum(DifficultyEnum.EASY).build();
        MemoCard spacecraft = MemoCard.builder().name("spacecraft").definition("statek kosmiczny").category(vehicles).difficultyEnum(DifficultyEnum.VERY_HARD).build();
        MemoCard hovercraft = MemoCard.builder().name("hovercraft").definition("poduszkowiec").category(vehicles).difficultyEnum(DifficultyEnum.HARD).build();

        List<MemoCard> vehiclesMemoCards = Arrays.asList(car, airplane, train, tram, bus, bike, scooter, truck, boat, ship, ferry, helicopter, spacecraft, hovercraft);
        memoCardRepository.saveAll(vehiclesMemoCards);
        vehicles.setMemoCardList(vehiclesMemoCards);
        categoryRepository.save(vehicles);

        // Items
        MemoCard phone = MemoCard.builder().name("phone").definition("telefon").category(items).difficultyEnum(DifficultyEnum.MEDIUM).build();
        MemoCard computer = MemoCard.builder().name("computer").definition("komputer").category(items).difficultyEnum(DifficultyEnum.EASY).build();
        MemoCard speaker = MemoCard.builder().name("speaker").definition("głośnik").category(items).difficultyEnum(DifficultyEnum.MEDIUM).build();
        MemoCard keyboard = MemoCard.builder().name("keyboard").definition("klawiatura").category(items).difficultyEnum(DifficultyEnum.MEDIUM).build();
        MemoCard computerMouse = MemoCard.builder().name("computer mouse").definition("mysz komputerowa").category(items).difficultyEnum(DifficultyEnum.HARD).build();
        MemoCard microphone = MemoCard.builder().name("microphone").definition("mikrofon").category(items).difficultyEnum(DifficultyEnum.EASY).build();
        MemoCard cable = MemoCard.builder().name("cable").definition("kabel").category(items).difficultyEnum(DifficultyEnum.MEDIUM).build();
        MemoCard headphones = MemoCard.builder().name("headphones").definition("słuchawki").category(items).difficultyEnum(DifficultyEnum.MEDIUM).build();
        MemoCard card = MemoCard.builder().name("card").definition("karta").category(items).difficultyEnum(DifficultyEnum.EASY).build();
        MemoCard key = MemoCard.builder().name("key").definition("klucz").category(items).difficultyEnum(DifficultyEnum.MEDIUM).build();
        MemoCard camera = MemoCard.builder().name("camera").definition("kamera").category(items).difficultyEnum(DifficultyEnum.EASY).build();
        MemoCard screen = MemoCard.builder().name("screen").definition("ekran").category(items).difficultyEnum(DifficultyEnum.EASY).build();
        MemoCard guitar = MemoCard.builder().name("guitar").definition("gitara").category(items).difficultyEnum(DifficultyEnum.EASY).build();
        MemoCard stick = MemoCard.builder().name("stick").definition("patyk").category(items).difficultyEnum(DifficultyEnum.EASY).build();
        MemoCard spray = MemoCard.builder().name("spray").definition("sprej").category(items).difficultyEnum(DifficultyEnum.EASY).build();
        MemoCard charger = MemoCard.builder().name("charger").definition("ładowarka").category(items).difficultyEnum(DifficultyEnum.MEDIUM).build();
        MemoCard notebook = MemoCard.builder().name("notebook").definition("zeszyt").category(items).difficultyEnum(DifficultyEnum.MEDIUM).build();
        MemoCard book = MemoCard.builder().name("book").definition("książka").category(items).difficultyEnum(DifficultyEnum.MEDIUM).build();

        List<MemoCard> itemsMemoCards = Arrays.asList(phone, computer, speaker, keyboard, computerMouse, microphone, cable, headphones, card, key, camera, screen, guitar, stick, spray, charger, notebook, book);
        memoCardRepository.saveAll(itemsMemoCards);
        items.setMemoCardList(itemsMemoCards);
        categoryRepository.save(items);

        // Work
        MemoCard teacher = MemoCard.builder().name("teacher").definition("nauczyciel").category(work).difficultyEnum(DifficultyEnum.MEDIUM).build();
        MemoCard policeman = MemoCard.builder().name("policeman").definition("policjant").category(work).difficultyEnum(DifficultyEnum.EASY).build();
        MemoCard firefighter = MemoCard.builder().name("firefighter").definition("strażak").category(work).difficultyEnum(DifficultyEnum.MEDIUM).build();
        MemoCard doctor = MemoCard.builder().name("doctor").definition("lekarz").category(work).difficultyEnum(DifficultyEnum.MEDIUM).build();
        MemoCard instructor = MemoCard.builder().name("instructor").definition("instruktor").category(work).difficultyEnum(DifficultyEnum.EASY).build();
        MemoCard nurse = MemoCard.builder().name("nurse").definition("pielęgniarka").category(work).difficultyEnum(DifficultyEnum.HARD).build();
        MemoCard tailor = MemoCard.builder().name("tailor").definition("krawiec").category(work).difficultyEnum(DifficultyEnum.MEDIUM).build();

        List<MemoCard> workMemoCards = Arrays.asList(teacher, policeman, firefighter, doctor, instructor, nurse, tailor);
        memoCardRepository.saveAll(workMemoCards);
        work.setMemoCardList(workMemoCards);
        categoryRepository.save(work);

        // Drinks
        MemoCard water = MemoCard.builder().name("water").definition("woda").category(drinks).difficultyEnum(DifficultyEnum.EASY).build();
        MemoCard juice = MemoCard.builder().name("juice").definition("sok").category(drinks).difficultyEnum(DifficultyEnum.EASY).build();
        MemoCard coffee = MemoCard.builder().name("coffee").definition("kawa").category(drinks).difficultyEnum(DifficultyEnum.EASY).build();
        MemoCard tea = MemoCard.builder().name("tea").definition("herbata").category(drinks).difficultyEnum(DifficultyEnum.MEDIUM).build();
        MemoCard lemonade = MemoCard.builder().name("lemonade").definition("lemoniada").category(drinks).difficultyEnum(DifficultyEnum.EASY).build();
        MemoCard beer = MemoCard.builder().name("beer").definition("piwo").category(drinks).difficultyEnum(DifficultyEnum.EASY).build();
        MemoCard energyDrink = MemoCard.builder().name("energy drink").definition("napój energetyczny").category(drinks).difficultyEnum(DifficultyEnum.VERY_HARD).build();
        MemoCard hotChocolate = MemoCard.builder().name("hot chocolate").definition("gorąca czekolada").category(drinks).difficultyEnum(DifficultyEnum.VERY_HARD).build();

        List<MemoCard> drinksMemoCards = Arrays.asList(water, juice, coffee, tea, lemonade, beer, energyDrink, hotChocolate);
        memoCardRepository.saveAll(drinksMemoCards);
        drinks.setMemoCardList(drinksMemoCards);
        categoryRepository.save(drinks);

        Byte[] userImage = getBytes("src/main/resources/static/pictures/student.jpg");

        User user = User.builder().firstName("Tester").image(userImage).points(0).build();
        userRepository.save(user);
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