package com.midterm.securevpnproxy.base.compose

import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class AppColorsPalette(
    val white: Color = Color.Unspecified,
    val black: Color = Color.Unspecified,
    val neutral10: Color = Color.Unspecified,
    val neutral20: Color = Color.Unspecified,
    val neutral30: Color = Color.Unspecified,
    val neutral40: Color = Color.Unspecified,
    val neutral50: Color = Color.Unspecified,
    val neutral60: Color = Color.Unspecified,
    val neutral70: Color = Color.Unspecified,
    val neutral80: Color = Color.Unspecified,
    val neutral90: Color = Color.Unspecified,
    val neutral100: Color = Color.Unspecified,
    val dangerMain: Color = Color.Unspecified,
    val dangerSurface: Color = Color.Unspecified,
    val dangerBorder: Color = Color.Unspecified,
    val dangerHover: Color = Color.Unspecified,
    val dangerPressed: Color = Color.Unspecified,
    val dangerFocus: Color = Color.Unspecified,
    val warningMain: Color = Color.Unspecified,
    val warningSurface: Color = Color.Unspecified,
    val warningBorder: Color = Color.Unspecified,
    val warningHover: Color = Color.Unspecified,
    val warningPressed: Color = Color.Unspecified,
    val warningFocus: Color = Color.Unspecified,
    val successMain: Color = Color.Unspecified,
    val successSurface: Color = Color.Unspecified,
    val successBorder: Color = Color.Unspecified,
    val successHover: Color = Color.Unspecified,
    val successPressed: Color = Color.Unspecified,
    val successFocus: Color = Color.Unspecified,
    val infoMain: Color = Color.Unspecified,
    val infoSurface: Color = Color.Unspecified,
    val infoBorder: Color = Color.Unspecified,
    val infoHover: Color = Color.Unspecified,
    val infoPressed: Color = Color.Unspecified,
    val infoFocus: Color = Color.Unspecified,
    val colorF5F5F5: Color = Color.Unspecified,
    val colorF8F8F8: Color = Color.Unspecified,
    val colorF9F9F9: Color = Color.Unspecified,
)

val LocalColors = staticCompositionLocalOf { AppColorsPalette() }

//val AppDarkColorsPalette = AppColorsPalette(
//    darkGrey09 = AbsDarkGrey09,
//    darkGrey08 = AbsDarkGrey08,
//    darkGrey07 = AbsDarkGrey07,
//    darkGrey06 = AbsDarkGrey06,
//    darkGrey05 = AbsDarkGrey05,
//    darkGrey04 = AbsDarkGrey04,
//    darkGrey03 = AbsDarkGrey03,
//    darkGrey02 = AbsDarkGrey02,
//    darkGrey01 = AbsDarkGrey01,
//    lightGrey01 = AbsLightGrey01,
//    lightGrey02 = AbsLightGrey02,
//    lightGrey03 = AbsLightGrey03,
//    lightGrey04 = AbsLightGrey04,
//    lightGrey05 = AbsLightGrey05,
//    lightGrey06 = AbsLightGrey06,
//    lightGrey07 = AbsLightGrey07,
//    lightGrey08 = AbsLightGrey08,
//    lightGrey09 = AbsLightGrey09,
//    blue10 = AbsBlue10,
//    blue09 = AbsBlue09,
//    blue08 = AbsBlue08,
//    blue07 = AbsBlue07,
//    blue06 = AbsBlue06,
//    blue05 = AbsBlue05,
//    blue04 = AbsBlue04,
//    blue03 = AbsBlue03,
//    blue02 = AbsBlue02,
//    blue01 = AbsBlue01,
//    blueAlpha04 = AbsLightBlueAlpha04,
//    green10 = AbsGreen10,
//    green09 = AbsGreen09,
//    green08 = AbsGreen08,
//    green07 = AbsGreen07,
//    green06 = AbsGreen06,
//    green05 = AbsGreen05,
//    green04 = AbsGreen04,
//    green03 = AbsGreen03,
//    green02 = AbsGreen02,
//    green01 = AbsGreen01,
//    red07 = AbsRed07,
//    red06 = AbsRed06,
//    red05 = AbsRed05,
//    orange06 = AbsOrange06,
//    orange05 = AbsOrange05,
//    orange04 = AbsOrange04,
//    orange03 = AbsOrange03,
//    orange02 = AbsOrange02,
//    orange01 = AbsOrange01,
//    blackAlpha01 = AbsBlackAlpha01,
//    blackAlpha02 = AbsBlackAlpha02,
//    blackAlpha03 = AbsBlackAlpha03,
//    blackAlpha04 = AbsBlackAlpha04,
//    blackAlpha05 = AbsBlackAlpha05,
//    blackAlpha06 = AbsBlackAlpha06,
//    blackAlpha07 = AbsBlackAlpha07,
//    blackAlpha08 = AbsBlackAlpha08,
//    blackAlpha09 = AbsBlackAlpha09,
//    whiteAlpha01 = AbsWhiteAlpha01,
//    whiteAlpha02 = AbsWhiteAlpha02,
//    whiteAlpha03 = AbsWhiteAlpha03,
//    whiteAlpha04 = AbsWhiteAlpha04,
//    whiteAlpha05 = AbsWhiteAlpha05,
//    whiteAlpha06 = AbsWhiteAlpha06,
//    whiteAlpha07 = AbsWhiteAlpha07,
//    whiteAlpha08 = AbsWhiteAlpha08,
//    whiteAlpha09 = AbsWhiteAlpha09,
//    white = AbsWhite,
//    purple04 = AbsPurple04,
//    black = AbsBlack,
//)

val AppLightColorsPalette = AppColorsPalette(
    white = AbsWhite,
    black = AbsBlack,
    neutral10 = Neutral10,
    neutral20 = Neutral20,
    neutral30 = Neutral30,
    neutral40 = Neutral40,
    neutral50 = Neutral50,
    neutral60 = Neutral60,
    neutral70 = Neutral70,
    neutral80 = Neutral80,
    neutral90 = Neutral90,
    neutral100 = Neutral100,
    dangerMain = DangerMain,
    dangerSurface = DangerSurface,
    dangerBorder = DangerBorder,
    dangerHover = DangerHover,
    dangerPressed = DangerPressed,
    dangerFocus = DangerFocus,
    warningMain = WarningMain,
    warningSurface = WarningSurface,
    warningBorder = WarningBorder,
    warningHover = WarningHover,
    warningPressed = WarningPressed,
    warningFocus = WarningFocus,
    successMain = SuccessMain,
    successSurface = SuccessSurface,
    successBorder = SuccessBorder,
    successHover = SuccessHover,
    successPressed = SuccessPressed,
    successFocus = SuccessFocus,
    infoMain = InfoMain,
    infoSurface = InfoSurface,
    infoBorder = InfoBorder,
    infoHover = InfoHover,
    infoPressed = InfoPressed,
    infoFocus = InfoFocus,
    colorF5F5F5 = ColorF5F5F5,
    colorF8F8F8 = ColorF8F8F8,
    colorF9F9F9 = ColorF9F9F9,
)

//val DarkColorPalette = darkColors(
//    primary = AbsDarkGrey08,
//    primaryVariant = AbsWhite,
//    secondary = AbsWhite,
//    secondaryVariant = AbsWhite,
//    onPrimary = AbsWhite,
//    onSecondary = AbsWhite,
//)
val LightColorPalette = lightColors(
    primary = InfoMain,
    primaryVariant = AbsWhite,
    secondary = AbsWhite,
    secondaryVariant = AbsWhite,
    onPrimary = AbsWhite,
    onSecondary = AbsWhite,
)

//val DarkTextSelectionColors =
//    TextSelectionColors(handleColor = InfoMain, backgroundColor = InfoMain)
val LightTextSelectionColors =
    TextSelectionColors(handleColor = InfoMain, backgroundColor = InfoMain)
