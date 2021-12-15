<template>
  <nav>
    <ul>
<!--      <li><nuxt-link exact to="/">Home</nuxt-link></li>-->
      <li><nuxt-link exact to="/"><AppLogo /></nuxt-link></li>
      <li><nuxt-link  to="/restaurants">Restaurants</nuxt-link></li>
    </ul>

    <ul>
      <li><nuxt-link  to="/cart">Cart</nuxt-link></li>
      <div class="smallnum" v-if="cartCount > 0" >{{cartCount}}</div>
      <li><nuxt-link  to="/login">Login</nuxt-link></li>
    </ul>
  </nav>
</template>

<script>
import AppLogo from '@/components/AppLogo.vue';
import {mapGetters} from "vuex";

export default {
  components: {
    AppLogo
  },
  computed: {
    ...mapGetters(["cartCount"])
  }
};
</script>

<style lang="scss" scoped>

</style>
