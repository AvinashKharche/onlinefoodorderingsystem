<template>
  <section class="masthead" role="img" aria-label="Image Description">
    <h1>
      Food Delivery
    </h1>
    <nuxt-link to="/restaurants">
      <button>
        Find a restaurant >
      </button>
    </nuxt-link>
  </section>
</template>

<script>
export default {};
</script>

<style lang="scss" scoped>
.masthead {
  //display: flex;
  //justify-content: center;
  //align-items: center;
  //flex-direction: column;
  //text-align: center;
  width: 100%;
  //height: 100vh; /* if you don't want it to take up the full screen, reduce this number */
  height: 80vh; /* if you don't want it to take up the full screen, reduce this number */
  padding: 40px;
  overflow: hidden;
  background-size: cover !important;
  background: linear-gradient(to top, rgba(0,0,0,0) 0%, rgba(0,0,0,0) 68%, rgba(0,0,0,0.65) 100%),
  url(~assets/headerimg.jpg) no-repeat center center scroll;
}

h1 {
  font-style: normal;
  font-weight: bold;
  color: #eee;
  //font-size: 11vmin;
  font-size: 8vmin;
  letter-spacing: 0.03em;
  line-height: 1;
  text-shadow: 1px 2px 4px rgba(0, 0, 0, 0.8);
  margin-bottom: 71px;
}
</style>
