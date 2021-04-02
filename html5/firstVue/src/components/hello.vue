<template>
  <div class="container">
    <p></p>
    <input type="text" id="input">
    <button class="btn btn-info"  @click="hello">按钮</button>
  </div>
</template>

<script>
export default {
  name: "hello",
  methods:{
    hello(){
      alert($("#input").val());
    },
  }
}
</script>

<style scoped>

</style>
