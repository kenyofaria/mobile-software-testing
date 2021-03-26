package br.mobile.software.testing;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import br.mobile.software.testing.ui.LoginActivity;

public class LoginTest {

    @Rule
    public ActivityTestRule<LoginActivity> loginActivity = new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void deve_EfetuarLoginComSucesso(){
        Espresso.onView(ViewMatchers.withId(R.id.login_input)).perform(ViewActions.typeText("auri"));
        Espresso.onView(ViewMatchers.withId(R.id.senha_input)).perform(ViewActions.typeText("333"));
        Espresso.onView(ViewMatchers.withId(R.id.senha_input)).perform(ViewActions.closeSoftKeyboard());

        Espresso.onView(ViewMatchers.withId(R.id.btn_login)).perform(ViewActions.click());

        Espresso.onView(ViewMatchers.withId(R.id.tela_de_filmes)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));

    }

//    onView(ViewMatcher)
//	.perform(ViewAction)
//	.check(ViewAssertion);
}
