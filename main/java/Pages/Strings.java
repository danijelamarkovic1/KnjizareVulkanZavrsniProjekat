package Pages;

public class Strings {

    // URLs
    public static final String HOME_PAGE_URL = "https://www.knjizare-vulkan.rs/";
    public static final String SHOPPING_CART_PAGE_URL = "https://www.knjizare-vulkan.rs/kupovina";
    public static final String KATEGORIJE_PROIZVODA_URL = "https://www.knjizare-vulkan.rs/kategorije-proizvoda-landing";
    public static final String TELEVIZOR_URL = "https://www.knjizare-vulkan.rs/proizvodi?search=televizor";
    public static final String SVE_KATEGORIJE_PROIZVODA_URL = "https://www.knjizare-vulkan.rs/proizvodi/page-0";
    public static final String FILTER_PROIZVODA_URL = "https://www.knjizare-vulkan.rs/proizvodi/finesa/bros/cirilica/?prices=0-750";
    // Social network URLs
    public static final String FACEBOOK_URL = "https://www.facebook.com/vulkanknjizare";
    public static final String TWITTER_URL = "https://twitter.com/Knjizare_Vulkan";
    public static final String INSTAGRAM_URL = "https://www.instagram.com/vulkan_knjizare/";
    public static final String TIKTOK_URL = "https://www.tiktok.com/@vulkan_knjizare";

    // Navbar category URLs
    public static final String KATEGORIJA_PROIZVODA_URL = "https://www.knjizare-vulkan.rs/kategorije-proizvoda-landing";
    public static final String AKCIJE_URL = "https://www.knjizare-vulkan.rs/akcije";
    public static final String NOVA_IZDANJA_URL = "https://www.knjizare-vulkan.rs/domace-knjige/novo-domace-knjige/";
    public static final String GIFT_KARTICE_URL = "https://www.knjizare-vulkan.rs/gift-landing";
    public static final String LICNI_RAZVOJ_URL = "https://www.knjizare-vulkan.rs/licni-razvoj-zdrav-zivot-landing";
    public static final String TITTOK_HITOVI_URL = "https://www.knjizare-vulkan.rs/tiktok-hitovi-preporuka";
    public static final String HARRY_POTTER_URL = "https://www.knjizare-vulkan.rs/proizvodi/hari-poter-sve-na-jednom-mestu/";
    public static final String USKORO_URL = "https://www.knjizare-vulkan.rs/domace-knjige/uskoro-u-prodaji";
    // Filter URLs
    public static final String ZA_DECU_URL = "https://www.knjizare-vulkan.rs/za-decu";


    // NavBar categories page titles
    public static final String KATEGORIJE_PROIZVODA_PAGE_TITLE = "KATEGORIJE";
    public static final String AKCIJE_PAGE_TITLE = "AKCIJE";
    public static final String NOVA_IZDANJA_PAGE_TITLE = "NOVA IZDANJA";
    public static final String GIFT_KARTICE_PAGE_TITLE = "GIFT KARTICE";
    public static final String LICNI_RAZVOJ_PAGE_TITLE = "LIČNI RAZVOJ";
    public static final String TITTOK_HITOVI_PAGE_TITLE = "TIKTOK HITOVI";
    public static final String HARRY_POTTER_PAGE_TITLE = "HARRY POTTER";
    public static final String USKORO_PAGE_TITLE = "USKORO";


    // Navbar category titles
    public static final String KATEGORIJE_PROIZVODA_NAVBAR_TITLE = "KATEGORIJE";
    public static final String AKCIJE_NAVBAR_TITLE = "AKCIJE";
    public static final String NOVA_IZDANJA_NAVBAR_TITLE = "NOVA IZDANJA";
    public static final String GIFT_KARTICE_NAVBAR_TITLE = "GIFT KARTICE";
    public static final String LICNI_RAZVOJ_NAVBAR_TITLE = "LIČNI RAZVOJ";
    public static final String TITTOK_HITOVI_NAVBAR_TITLE = "TIKTOK HITOVI";
    public static final String HARRY_POTTER_NAVBAR_TITLE = "HARRY POTTER";
    public static final String USKORO_NBAR_TITLE = "USKORO";


    // Titles from filter list checkboxes
    public static final String FINESA_IZDAVAC_CHECKBOX_TITILE ="FINESA";
    public static final String BROS_POVEZ_CHECKBOX_TITLE = "BROŠ";
    public static final String PISMO_CHECKBOX_TITLE = "ĆIRILICA";
    public static final String CENA_CHECKBOX_TITLE = "0-750 RSD";

    // Sort dropdown texts
    public static final String NAJNOVIJE = "Najnovije";
    public static final String LOW_TO_HIGH = "Najjeftinije prvo";
    public static final String HIGH_TO_LOW = "Najskuplje prvo";
    public static final String LOWEST_DISCOUNT_TO_PRICE_VALUE = "Najmanji popust prvo u odnosu na cenu";
    public static final String HIGHEST_DOSCOUNT_TO_PRICE_VALUE = "Najveći popust prvo u odnosu na cenu";
    public static final String BY_NAME = "Po nazivu";
    public static final String RECOMMENDED = "Preporučujemo";
    public static final String EMPTY_CART_MESSAGE = "Vaša korpa je prazna!";

    // Item titles


    public static final String ADIDAS_PATIKE_TITLE = "ADIDAS Patike SUPERTURF ADVENTURE SW";
    public static final String NIKE_DONJI_DEO_TRENERKE_TITLE = "NIKE Donji deo trenerke W J HERITAGE WOVEN PANT";
    public static final String DZUNGLA_SLIKOVNICA_TITLE = "DZUNGLA Slikovnica rasklapalica";
    public static final String ADIDAS_DUKSERICA_TITLE =  "ADIDAS Dukserica HOODIE";

    // Xpaths
    public static final String IZDAVAC_FILTER_LIST_XPATH = " //div[@id='nb_f-attr-2']//ul[contains(@class,'items-wrapper')]";
    public static final String POVEZ_FILTER_LIST_XPATH = "//div[@id='nb_f-attr-10']//ul[contains(@class,'items-wrapper')]";
    public static final String PISMO_FILTER_LIST_XPATH = " //div[@id='nb_f-attr-11']//ul[contains(@class,'items-wrapper')]";
    public static final String BREND_FILTER_LIST_XPATH = " //div[@id='nb_f-attr-12']//ul[contains(@class,'items-wrapper')]";
    public static final String RASPON_CENA_LIST_XPATH = "//div[contains(@class,'filter-group filter-price-wrapper')]//ul[contains(@class,'items-wrapper')]";
    public static final String ALL_ITEM_LIST_XPATH = "//div[@class='product-listing appear appeared'";
    public static final String ALL_ITEM_PRICES_XPATH = "//div[@class='prices-wrapper']";
    public static final String NAVBAR_CATEGORY_LIST_XPATH = "//ul[@class='nav-main list-inline']";
    public static final String ALERT_MESSAGE_CONTAINER_XPATH = "//div[@class='alert alert-danger']";
    public static final String SHOPPING_CART_ITEM_LIST_XPATH = "//td//div[@class='product-item-title text-left']/a";
    public static final String SHOPPING_CART_ITEM_PRICES_LIST_XPATH = "//span[@class='product-item-prices']";
    public static final String REMOVE_FROM_CART_BUTTON_XPATH = "//div[@class = 'cart-col-inner-wrapper']/a";
    public static final String EMPTY_CART_MESSAGE_XPATH = "//div[@class = 'alert alert-danger']";
    public static final String SEARCH_ALERT_MESSAGE_XPATH = "//div[@class =  'alert alert-info']";
    public static final String HEADER_LOGO_XPATH = "//div[@class='container']//div[@class='block logo']";

    // Puma brand URL
    public static final String SMRTNI_ISHODI_ATLETSKIH_POVREDA_URL = "https://www.knjizare-vulkan.rs/domaci-roman/92606-smrtni-ishod-atletskih-povreda";

    // ALL PAGES TITLE XPATH
    public static final String ALL_PAGES_TITLE_XPATH = "//h1//span";

    // Register/login form data

    public static final String VALID_EMAIL = "danijelamarkovic06@gmail.com";
    public static final String VALID_PASSWORD = "danijelica";
    public static final String FIRST_NAME = "Testerka";
    public static final String LAST_NAME = "TestiC";
    public static final String EMAIL = "tEsttEsTiC@gmail.com";
    public static final String PHONE_NUMBER = "0612345678";
    public static final String COUNTRY_NAME = "Srbija";
    public static final String CITY = "Leskovac";
    public static final String STREET = "Milenka Grbica";
    public static final String STREET_NUMBER = "15";
    public static final String POSTAL_CODE = "16000";
    public static final String  PASSWORD = "*Test1234";
    public static final String INVALID_PASSWORD = "zvezdaca";
    public static final String REGISTER_ALERT_SECURITY_MESSAGE_TEXT = "Изазов за верификацију је истекао. Означите поново поље за потврду.";
    public static final String REGISTER_ALERT_MESSAGE_TEXT = "Neispravno popunjeno anti spam polje!";

    // Registration success alert texts
    public static final String REGISTRATION_SUCCESS_TEXT = "'Uspešno ste započeli proces registracije. Na email adresu koju ste naveli poslate su instrukcije za kompletiranje procesa registracije. Molimo vas proverite Vašu email adresu!'";
    public static final String REGISTRATION_PAGE_FINAL_SUCCESS_TEXT = "Čestitamo! Uspešno ste se registrovali na  Tike.rs.";

    // Alert message text for login with invalid credentials
    public static final String LOGIN_ALERT_MESSAGE_TEXT = "Pogrešna email adresa ili lozinka. Molimo Vas pokušajte ponovo!";

    // Search alert message text
    public static final String SEARCH_ALERT_MESSAGE_TEXT = "Za izabrane kriterijume nisu pronađeni proizvodi!";




    public static final String KNJIGA_ZA_DECU ="https://www.knjizare-vulkan.rs/proizvodi?search=KI%C5%A0NI+OBLAK";

    public static final String POIZVODI_ZA_DECU= "https://www.knjizare-vulkan.rs/proizvodi?search=carobne+price";
    public static final String CAROBNE_PRICE_URL= "https://www.knjizare-vulkan.rs/decje-knjige-za-uzrast-od-3-do-6-godina/18003-carobne-price";
    public static final String PRICE="ČAROBNE PRIČE ";



    //xpath
    public static final String XPATH_SMRTNI_ISHODI_ATLETSKIH_POVREDA = "//div[@class='img-wrapper']//a[@title='SMRTNI ISHOD ATLETSKIH POVREDA ']";
    public static final String SMRTNI_ISHODI_ATLETSKIH_POVREDA_TEXT = "SMRTNI ISHODI ATLETSKIH POVREDA";

}
