package br.com.unifor.personview.repository

import br.com.unifor.personview.R
import br.com.unifor.personview.model.User

object UserRepository {
    fun findAll():List<User>{
        return listOf(
            User(1,"Tristan Carroll","tristan.carroll@example.com","7/5/1980", R.drawable.f1),
            User(2,"Tristan Porter","tristan.porter@example.com","6/3/1948", R.drawable.f2),
            User(3,"Leo Weaver","leo.weaver@example.com","2/6/1974", R.drawable.f3),
            User(4,"Anne Boyd","anne.boyd@example.com","2/6/1975", R.drawable.f4),
            User(5,"Eileen Myers","eileen.myers@example.com","7/2/1975", R.drawable.f5),
            User(6,"Cameron Chambers","cameron.chambers@example.com","9/7/1988", R.drawable.f6),
            User(7,"Lena Montgomery","lena.montgomery@example.com","5/5/1994", R.drawable.f7),
            User(8,"Vernon Willis","vernon.willis@example.com","6/2/1988", R.drawable.f8),
            User(9,"Larry Thompson","larry.thompson@example.com","6/7/1973", R.drawable.f9),
            User(10,"Beatrice Foster","beatrice.foster@example.com","6/3/1975", R.drawable.f10),

        )

    }
}