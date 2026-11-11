package sadeqit.github.io.presentation.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import sadeqit.github.io.presentation.components.app.AppFooter
import sadeqit.github.io.presentation.components.ContentSection
import sadeqit.github.io.presentation.components.SkillList
import sadeqit.github.io.presentation.screens.home.HomeReveal
import sadeqit.github.io.presentation.theme.AppBreakpoints
import sadeqit.github.io.presentation.theme.AppDimensions
import sadeqit.shared.generated.resources.Res
import sadeqit.shared.generated.resources.about_profile
import sadeqit.shared.generated.resources.contact


@Composable
fun AboutScreen(
    onContactClick: () -> Unit,
) {
    BoxWithConstraints(
        modifier = Modifier.fillMaxSize()
    ) {
        val isMobile = maxWidth < AppBreakpoints.Mobile

        val contentModifier = Modifier
            .widthIn(max = 1100.dp)
            .fillMaxWidth()
            .padding(horizontal = if (isMobile) 16.dp else 0.dp)

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(
                top = AppDimensions.Space32,
                bottom = 0.dp
            ),
            verticalArrangement = Arrangement.spacedBy(
                AppDimensions.Space24
            ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item(key = "about-intro") {
                HomeReveal {
                    AboutIntro(
                        modifier = contentModifier,
                        isMobile = isMobile
                    )
                }
            }

            item(key = "about-divider-story") {
                Box(contentModifier) {
                    HorizontalDivider(
                        color = MaterialTheme.colorScheme.outlineVariant,
                        thickness = 2.dp
                    )
                }
            }


            item(key = "about-story") {
                HomeReveal {
                    ContentSection(
                        title = "مسیر من",
                        modifier = contentModifier
                    ) {
                        Text(
                            text = "مسیر من در دنیای برنامه‌نویسی از سال ۱۴۰۰ و با علاقه به یادگیری توسعه نرم‌افزار و ساخت راهکارهای کاربردی آغاز شد. در طول این مسیر، با کسب تجربه و آشنایی با فناوری‌های مختلف، به‌تدریج تمرکز خود را بر توسعه اپلیکیشن‌های اندرویدی و زبان Kotlin قرار دادم؛ حوزه‌ای که به دلیل انعطاف‌پذیری، امکانات گسترده و جامعه توسعه‌دهندگان فعال، به زمینه اصلی فعالیت من تبدیل شد.",
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.onBackground,
                            textAlign = TextAlign.Justify
                        )

                        Text(
                            text = "با عمیق‌تر شدن در توسعه Android، علاقه‌ام به مباحثی مانند معماری نرم‌افزار، طراحی رابط کاربری، مدیریت وضعیت و بهینه‌سازی عملکرد بیشتر شد. تلاش کردم در کنار یادگیری ابزارها و فناوری‌ها، اصولی مانند خوانایی کد، جداسازی مسئولیت‌ها، نگهداری‌پذیری و انتخاب راهکار متناسب با نیاز هر پروژه را نیز در کار خود به کار بگیرم.",
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.onBackground,
                            textAlign = TextAlign.Justify
                        )

                        Text(
                            text = "در ادامه این مسیر، با Kotlin Multiplatform و Compose Multiplatform آشنا شدم و توسعه چندسکویی را نیز به حوزه فعالیت خود اضافه کردم. این فناوری‌ها برایم فرصتی فراهم کردند تا از زبان و ابزارهای Kotlin برای ساخت تجربه‌های نرم‌افزاری در پلتفرم‌های مختلف استفاده کنم و درک عمیق‌تری از طراحی و معماری محصولات چندسکویی به دست آورم.",
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.onBackground,
                            textAlign = TextAlign.Justify
                        )

                        Text(
                            text = "در کنار مطالعه و یادگیری مستمر، پیاده‌سازی پروژه‌های عملی بخش مهمی از مسیر رشد من بوده است. توسعه Weatherino و Sadegh Dream به من فرصت داده تا آموخته‌هایم را در پروژه‌های واقعی به کار بگیرم، با چالش‌های فنی روبه‌رو شوم و تجربه تبدیل ایده به محصولی قابل استفاده را کسب کنم.",
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.onBackground,
                            textAlign = TextAlign.Justify
                        )

                        Text(
                            text = "امروز همچنان این مسیر را با تمرکز بر توسعه Android و Kotlin Multiplatform، یادگیری فناوری‌های جدید و ارتقای کیفیت محصولات نرم‌افزاری ادامه می‌دهم. برای من رشد حرفه‌ای تنها به یادگیری ابزارهای بیشتر محدود نمی‌شود؛ بلکه توانایی تحلیل مسئله، تصمیم‌گیری فنی مناسب و ساخت محصولاتی قابل اعتماد و کاربرپسند نیز بخش مهمی از آن است.",
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.onBackground,
                            textAlign = TextAlign.Justify
                        )
                    }
                }
            }


            item(key = "about-divider-approach") {
                Box(contentModifier) {
                    HorizontalDivider(
                        color = MaterialTheme.colorScheme.outlineVariant,
                        thickness = 2.dp
                    )
                }
            }


            item(key = "about-approach") {
                HomeReveal {
                    ContentSection(
                        title = "نگاه من به توسعه نرم‌افزار",
                        modifier = contentModifier
                    ) {
                        AboutPrinciple(
                            title = "کیفیت و خوانایی کد",
                            description = "کیفیت کد را یکی از پایه‌های اصلی توسعه نرم‌افزار می‌دانم. تلاش می‌کنم کدی بنویسم که علاوه بر اجرای صحیح، ساختاری خوانا، قابل فهم و منظم داشته باشد. نام‌گذاری مناسب، جداسازی مسئولیت‌ها، کاهش وابستگی‌های غیرضروری و رعایت اصول برنامه‌نویسی به من کمک می‌کنند کدی توسعه‌پذیر بنویسم که درک، نگهداری و گسترش آن در آینده آسان‌تر باشد."
                        )

                        AboutPrinciple(
                            title = "معماری و ساختار اصولی",
                            description = "انتخاب معماری مناسب را متناسب با ابعاد، نیازها و پیچیدگی هر پروژه انجام می‌دهم. استفاده آگاهانه از مفاهیمی مانند Clean Architecture، اصول SOLID و الگوهای طراحی به من کمک می‌کند مسئولیت‌ها را به‌درستی تفکیک کنم، وابستگی میان بخش‌های مختلف را کاهش دهم و بستری مناسب برای توسعه و تغییرات آینده فراهم کنم. در عین حال، از پیچیده کردن ساختار پروژه با راهکارهایی که ضرورتی ندارند پرهیز می‌کنم."
                        )

                        AboutPrinciple(
                            title = "تجربه کاربری و طراحی رابط کاربری",
                            description = "یک محصول نرم‌افزاری زمانی ارزشمند است که استفاده از آن برای کاربر ساده، قابل فهم و لذت‌بخش باشد. به همین دلیل، در کنار پیاده‌سازی قابلیت‌ها به جزئیاتی مانند نظم بصری، هماهنگی اجزای رابط کاربری، واکنش‌گرایی در اندازه‌های مختلف صفحه‌نمایش و بازخورد مناسب به تعاملات کاربر توجه می‌کنم. هدفم ساخت رابط‌هایی است که علاوه بر ظاهر مناسب، تجربه‌ای روان و قابل اعتماد ارائه دهند."
                        )

                        AboutPrinciple(
                            title = "عملکرد و بهینه‌سازی",
                            description = "عملکرد مناسب را بخشی جدایی‌ناپذیر از کیفیت محصول می‌دانم. در تصمیم‌های فنی، عواملی مانند زمان اجرا، مصرف حافظه و پردازنده، حجم داده‌ها و پاسخ‌گویی رابط کاربری را در نظر می‌گیرم. بهینه‌سازی را بر اساس نیاز واقعی و شناسایی نقاط قابل بهبود انجام می‌دهم تا بدون تحمیل پیچیدگی غیرضروری، برنامه‌ای سریع، روان و پایدار توسعه دهم."
                        )

                        AboutPrinciple(
                            title = "حل مسئله و یادگیری مستمر",
                            description = "توسعه نرم‌افزار را فرایندی پیوسته از تحلیل، آزمایش و یادگیری می‌دانم. هنگام مواجهه با چالش‌های فنی، تلاش می‌کنم ابتدا مسئله و علت اصلی آن را به‌درستی شناسایی کنم و سپس راهکاری متناسب با شرایط پروژه انتخاب کنم. همچنین با دنبال کردن پیشرفت فناوری‌ها، مطالعه مستندات و به‌کارگیری آموخته‌های جدید در پروژه‌های عملی، دانش فنی خود را به‌روز نگه می‌دارم."
                        )
                    }
                }
            }


            item(key = "about-divider-interests") {
                Box(contentModifier) {
                    HorizontalDivider(
                        color = MaterialTheme.colorScheme.outlineVariant,
                        thickness = 2.dp
                    )
                }
            }


            item(key = "about-interests") {
                HomeReveal {
                    ContentSection(
                        title = "حوزه‌های تخصصی و علاقه‌مندی",
                        modifier = contentModifier
                    ) {
                        Text(
                            text = "تمرکز اصلی من بر توسعه اپلیکیشن‌های Android با زبان Kotlin و استفاده از Jetpack Compose برای ساخت رابط‌های کاربری مدرن و واکنش‌گرا است. همچنین با توسعه چندسکویی به کمک Kotlin Multiplatform و Compose Multiplatform فعالیت می‌کنم و به دنبال استفاده مؤثر از قابلیت‌های این فناوری‌ها برای توسعه محصولاتی با ساختار مشترک و تجربه کاربری متناسب با هر پلتفرم هستم.",
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.onBackground,
                            textAlign = TextAlign.Justify
                        )
                        HorizontalDivider()
                        Text(
                            text = "در بخش معماری و ساختار نرم‌افزار، به الگوهایی مانند MVVM و اصول Clean Architecture و SOLID توجه دارم. همچنین در پیاده‌سازی بخش‌های مختلف برنامه، از ابزارها و فناوری‌هایی مانند Coroutines و Flow برای مدیریت عملیات ناهمگام و جریان داده، Koin و Hilt برای مدیریت وابستگی‌ها، Ktor برای ارتباطات شبکه و SQLDelight برای ذخیره‌سازی داده‌ها استفاده می‌کنم.",
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.onBackground,
                            textAlign = TextAlign.Justify
                        )
                        HorizontalDivider()
                        Text(
                            text = "علاوه بر توسعه اپلیکیشن، به موضوعاتی مانند طراحی تجربه کاربری، بهینه‌سازی عملکرد، طراحی ساختارهای قابل نگهداری و توسعه نرم‌افزارهای چندسکویی علاقه‌مندم. برای من یادگیری فناوری‌های جدید زمانی ارزشمندتر است که بتوانم از آن‌ها برای حل مسائل واقعی و ارتقای کیفیت محصولات نرم‌افزاری استفاده کنم.",
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.onBackground,
                            textAlign = TextAlign.Justify
                        )

                        HorizontalDivider()
                        SkillList(
                            skills = listOf(
                                "Kotlin",
                                "Android",
                                "Jetpack Compose",
                                "Kotlin Multiplatform",
                                "Compose Multiplatform",
                                "Coroutines",
                                "Flow",
                                "MVVM",
                                "Clean Architecture",
                                "SOLID",
                                "Koin",
                                "Hilt",
                                "Ktor",
                                "SQLDelight",
                            ),
                        )
                    }
                }
            }


            item(key = "about-divider-projects") {
                Box(contentModifier) {
                    HorizontalDivider(
                        color = MaterialTheme.colorScheme.outlineVariant,
                        thickness = 2.dp
                    )
                }
            }

            item(key = "about-projects") {
                HomeReveal {
                    ContentSection(
                        title = "پروژه‌های منتخب",
                        modifier = contentModifier
                    ) {
                        AboutPrinciple(
                            title = "ودرینو",
                            description = "یک اپلیکیشن هواشناسی چندسکویی برای نمایش وضعیت فعلی آب‌وهوا، پیش‌بینی روزهای آینده و اطلاعات کیفیت هوا. این پروژه با استفاده از Kotlin Multiplatform و Compose Multiplatform توسعه داده شده و از معماری مشترک برای بخش‌های مختلف برنامه بهره می‌برد."
                        )

                        AboutPrinciple(
                            title = "تعبیر خواب صادق",
                            description = "یک اپلیکیشن اندرویدی برای جست‌وجو و مطالعه تعبیر خواب‌ها بر پایه منابع تعبیر خواب. در توسعه این پروژه از Kotlin و Jetpack Compose استفاده شده و توجه به تجربه کاربری، مدیریت اطلاعات و ساختاری قابل توسعه از بخش‌های مهم آن بوده است."
                        )

                        Text(
                            text = "علاوه بر این پروژه‌ها، روی پروژه‌های تمرینی و توسعه وب با Kotlin و Compose Multiplatform نیز کار می‌کنم. این فعالیت‌ها فرصتی برای گسترش مهارت‌ها، تجربه فناوری‌های جدید و به‌کارگیری آموخته‌ها در پروژه‌های عملی هستند.",
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.onBackground,
                            textAlign = TextAlign.Justify
                        )
                    }
                }
            }

            item(key = "about-divider-focus") {
                Box(contentModifier) {
                    HorizontalDivider(
                        color = MaterialTheme.colorScheme.outlineVariant,
                        thickness = 2.dp
                    )
                }
            }

            item(key = "about-focus") {
                HomeReveal {
                    ContentSection(
                        title = "تمرکز فعلی من",
                        modifier = contentModifier
                    ) {
                        Text(
                            text = "تمرکز فعلی من بر توسعه عمیق‌تر مهارت‌هایم در Kotlin Multiplatform و Compose Multiplatform و استفاده مؤثر از آن‌ها برای ساخت نرم‌افزارهای چندسکویی است. در کنار آن، به بهبود دانش خود در زمینه معماری نرم‌افزار، مدیریت وضعیت، برنامه‌نویسی ناهمگام و بهینه‌سازی عملکرد توجه دارم.",
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.onBackground,
                            textAlign = TextAlign.Justify
                        )

                        Text(
                            text = "هدفم این است که با یادگیری مستمر و تجربه عملی، محصولاتی توسعه دهم که علاوه بر تجربه کاربری مطلوب، از ساختار فنی منسجم، عملکرد روان، قابلیت نگهداری و امکان توسعه در آینده برخوردار باشند.",
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.onBackground,
                            textAlign = TextAlign.Justify
                        )
                    }
                }
            }

            item(key = "about-divider-contact") {
                Box(contentModifier) {
                    HorizontalDivider(
                        color = MaterialTheme.colorScheme.outlineVariant,
                        thickness = 2.dp
                    )
                }
            }

            item(key = "about-contact") {
                HomeReveal {
                    ContentSection(
                        title = "در ارتباط باشیم",
                        modifier = contentModifier
                    ) {
                        Text(
                            text = "اگر به دنبال همکاری در توسعه نرم‌افزار هستید، درباره پروژه‌هایم سؤالی دارید یا پیشنهادی برای همکاری دارید، خوشحال می‌شوم با شما در ارتباط باشم. از طریق صفحه تماس می‌توانید راه‌های ارتباطی با من را مشاهده کنید.",
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.onBackground,
                            textAlign = TextAlign.Justify
                        )

                        Row(
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .padding(top = 8.dp)
                                .clip(RoundedCornerShape(12.dp))
                                .border(
                                    width = 2.dp,
                                    color = MaterialTheme.colorScheme.primary.copy(alpha = 0.6f),
                                    shape = RoundedCornerShape(12.dp)
                                )
                                .clickable(onClick = onContactClick)
                                .padding(horizontal = 16.dp, vertical = 12.dp),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Image(
                                painter = painterResource(Res.drawable.contact),
                                contentDescription = null,
                                modifier = Modifier.size(30.dp)
                            )

                            Spacer(Modifier.width(8.dp))

                            Text(
                                text = "تماس با من",
                                style = MaterialTheme.typography.bodyLarge,
                                color = MaterialTheme.colorScheme.primary,
                            )
                        }
                    }
                }
            }

            item(key = "app-footer") {
                Box(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    CompositionLocalProvider(
                        LocalLayoutDirection provides
                                LayoutDirection.Ltr
                    ) {
                        AppFooter()
                    }
                }
            }
        }
    }
}

@Composable
private fun AboutIntro(
    modifier: Modifier = Modifier,
    isMobile: Boolean
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        border = BorderStroke(
            width = AppDimensions.BorderThin,
            color = MaterialTheme.colorScheme.outlineVariant
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            horizontalAlignment = if (isMobile) {
                Alignment.CenterHorizontally
            } else {
                Alignment.Start
            },
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            if (isMobile) {
                Image(
                    painter = painterResource(Res.drawable.about_profile),
                    contentDescription = "تصویر پروفایل",
                    modifier = Modifier
                        .size(180.dp)
                        .clip(CircleShape)
                        .border(
                            width = 3.dp,
                            color = MaterialTheme.colorScheme.primary,
                            shape = CircleShape
                        ),
                    contentScale = ContentScale.Crop
                )

                AboutIntroText(
                    modifier = Modifier.fillMaxWidth(),
                    centered = true
                )
            } else {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(32.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    AboutIntroText(
                        modifier = Modifier.weight(1f),
                        centered = false
                    )
                    Image(
                        painter = painterResource(Res.drawable.about_profile),
                        contentDescription = "تصویر پروفایل",
                        modifier = Modifier
                            .size(220.dp)
                            .clip(CircleShape)
                            .border(
                                width = 3.dp,
                                color = MaterialTheme.colorScheme.primary,
                                shape = CircleShape
                            ),
                        contentScale = ContentScale.Crop
                    )
                }
            }
        }
    }
}

@Composable
private fun AboutIntroText(
    modifier: Modifier = Modifier,
    centered: Boolean
) {
    Column(
        modifier = modifier,
        horizontalAlignment = if (centered) {
            Alignment.CenterHorizontally
        } else {
            Alignment.Start
        },
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "درباره من",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.SemiBold
        )

        Text(
            text = "توسعه‌دهنده Android و Kotlin Multiplatform",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.Bold,
            textAlign = if (centered) TextAlign.Center else TextAlign.Start
        )

        Text(
            text = "من به طراحی و توسعه اپلیکیشن‌هایی علاقه دارم که در کنار رابط کاربری مناسب، از ساختار فنی اصولی، عملکرد مطلوب و قابلیت توسعه برخوردار باشند.",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = if (centered) TextAlign.Center else TextAlign.Start
        )

        Text(
            text = "تمرکز اصلی من استفاده از Kotlin و اکوسیستم Compose برای ساخت تجربه‌های نرم‌افزاری مدرن و باکیفیت است.",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = if (centered) TextAlign.Center else TextAlign.Start
        )
    }
}

@Composable
private fun AboutPrinciple(
    title: String,
    description: String
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.primary
        )

        Text(
            text = description,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.Justify
        )
    }
    HorizontalDivider()
}